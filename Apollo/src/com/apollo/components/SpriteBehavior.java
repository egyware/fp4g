package com.apollo.components;

import com.apollo.annotate.InjectComponent;
import com.apollo.messages.SequenceMessage;
import com.apollo.messages.SequenceMessageHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.egysoft.gdx.assets.Sprite;

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
	private TransformBehavior transform;
	
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
		if(!isEnded && current.getPlayMode() == PlayMode.NORMAL && current.isAnimationFinished(time))
		{
			isEnded = true;
			owner.onMessage(SequenceMessage.onEndSequence);
		}
		time += delta;		
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);		
	}
	
	public void draw(Batch batch, float parentAlpha)
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
		Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
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
	public boolean isFlipX()
	{
		return flipX;
	}
	public boolean isFlipY()
	{
		return flipY;
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
		return (PlayMode.NORMAL == current.getPlayMode()) && current.isAnimationFinished(time);
	}
	
	@Override
	public String toString()
	{
		return String.format("SpriteBehavior: {flip_x: %b, flip_x: %b}", flipX,flipY);
	}
}
