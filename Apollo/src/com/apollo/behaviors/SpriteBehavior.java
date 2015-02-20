package com.apollo.behaviors;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
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
import com.egysoft.gdx.Game;
import com.egysoft.gdx.assets.Sprite;

public class SpriteBehavior extends ActorBehavior
implements SequenceMessageHandler
{
	public static class Template implements BehaviorTemplate
	{
		String sprite;

		@Override
		public Behavior createBehavior(final Engine engine)
		{
			Sprite s = Game.instance.assets.get(sprite);
			return new SpriteBehavior(s);
		}		
	}
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
		Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        final int fh = frame.getRegionHeight();
        final int fw = frame.getRegionWidth();
		batch.draw(frame, getX() - fw/2 - o.x, getY() - o.y, fw/2, fh/2, fw, fh, flipX?-1:1, flipY?-1:1, getRotation());
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
		owner.addMessageHandler(SequenceMessage.onChangeSequence, this);
	}
	
	public void deinitialize()
	{
		owner.removeMessageHandler(SequenceMessage.onChangeSequence, this);
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
