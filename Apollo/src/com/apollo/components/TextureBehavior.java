package com.apollo.components;

import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.graphics.Texture;

//TODO por reeimplementar
public class TextureBehavior extends ActorBehavior 
{
	@InjectComponent
	private TransformFamily transform;
	private Texture texture;
	private final int w;
	private final int h;
	 
	public TextureBehavior(Texture texture)
	{
		this.texture = texture;
		w = texture.getWidth();
		h = texture.getHeight();
	}
	
	public static TextureBehavior build(Texture texture)
	{
		return new TextureBehavior(texture);
	}
}
