package com.apollo.components;

import com.apollo.annotate.InjectComponent;
import com.apollo.managers.graphics.Sprite;
import com.apollo.messages.SequenceMessage;
import com.apollo.messages.SequenceMessageHandler;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class SpriteBehavior extends ActorBehavior
implements SequenceMessageHandler
{
	private Animation current;
	private Sprite sprite;
	private Vector2 o;		
	private float time;
	private boolean isEnded = false;
	private boolean flipX;
	private boolean flipY;
	
	@InjectComponent
	private TransformFamily transform;
	
	public SpriteBehavior(Sprite sprite)
	{
		this.sprite = sprite;
		o = sprite.origin();
		current = sprite.getFirstAnimation();		
	}
	
	public void setAnimation(String id)
	{
		current = sprite.getAnimation(id);
		time = 0;
		isEnded = false;
	}
	
	public void act(float delta)
	{
		super.act(delta);
		if(!isEnded && current.getPlayMode() == Animation.NORMAL && current.isAnimationFinished(time))
		{
			isEnded = true;
			owner.onMessage(SequenceMessage.onEndSequence);
		}
		time += delta;		
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);		
	}
	
	public void draw(SpriteBatch batch, float parentAlpha)
	{	
		TextureRegion frame = sprite.getKeyFrame(current,time);
		if(flipX && !frame.isFlipX())
		{
			frame.flip(true, false);
		}
		else if(!flipX && frame.isFlipX())
		{
			frame.flip(true, false);
		}
		if(flipY && !frame.isFlipY())
		{
			frame.flip(false,true);
		}
		else if(!flipY && frame.isFlipY())
		{
			frame.flip(false,true);
		}
		batch.draw(frame, getX() - frame.getRegionWidth()/2 - o.x, getY() - o.y);		
	}
	
	public void setFlipX(boolean b)
	{
		flipX = b;
	}
	public void setFlipY(boolean b)
	{
		flipY = b;
	}
	
	public static SpriteBehavior build(Sprite sprite)
	{
		return new SpriteBehavior(sprite);
	}
	
	public void initialize()
	{
		owner.addEventHandler(SequenceMessage.onChangeSequence, this);
	}
	
	public void deinitialize()
	{
		owner.removeEventHandler(SequenceMessage.onChangeSequence, this);
	}

	@Override
	public void onChangeSequence(String sequence) 
	{
		 setAnimation(sequence);
	}

	@Override
	public void onEndSequence() 
	{		
	}

	public boolean isEndedCurrentAnimation()
	{
		return (Animation.NORMAL == current.getPlayMode()) && current.isAnimationFinished(time);
	}
}
