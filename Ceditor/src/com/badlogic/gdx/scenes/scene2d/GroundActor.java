package com.badlogic.gdx.scenes.scene2d;

import static com.badlogic.gdx.graphics.g2d.Batch.C1;
import static com.badlogic.gdx.graphics.g2d.Batch.C2;
import static com.badlogic.gdx.graphics.g2d.Batch.C3;
import static com.badlogic.gdx.graphics.g2d.Batch.C4;
import static com.badlogic.gdx.graphics.g2d.Batch.U1;
import static com.badlogic.gdx.graphics.g2d.Batch.U2;
import static com.badlogic.gdx.graphics.g2d.Batch.U3;
import static com.badlogic.gdx.graphics.g2d.Batch.U4;
import static com.badlogic.gdx.graphics.g2d.Batch.V1;
import static com.badlogic.gdx.graphics.g2d.Batch.V2;
import static com.badlogic.gdx.graphics.g2d.Batch.V3;
import static com.badlogic.gdx.graphics.g2d.Batch.V4;
import static com.badlogic.gdx.graphics.g2d.Batch.X1;
import static com.badlogic.gdx.graphics.g2d.Batch.X2;
import static com.badlogic.gdx.graphics.g2d.Batch.X3;
import static com.badlogic.gdx.graphics.g2d.Batch.X4;
import static com.badlogic.gdx.graphics.g2d.Batch.Y1;
import static com.badlogic.gdx.graphics.g2d.Batch.Y2;
import static com.badlogic.gdx.graphics.g2d.Batch.Y3;
import static com.badlogic.gdx.graphics.g2d.Batch.Y4;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class GroundActor extends Actor
{
	private int tileWidth;
	private int tileHeight;
	private int columns;
	private int rows;
	
	private int[] data;
	private Array<TextureRegion> tiles;	
	
	public GroundActor(Array<TextureRegion> tiles, int tileWidth, int tileHeight, int rows, int columns)
	{
		this.tiles = tiles;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.columns = columns;
		this.rows = rows;
		
		data = new int[rows*columns];
		for(int i=0;i<data.length;i++)
		{
			data[i] = 27+i%3;
		}
		
		setBounds(0,0,columns*tileWidth, rows*tileHeight);
		
	}
	
	
	static protected final int NUM_VERTICES = 20;
	
	protected float vertices[] = new float[NUM_VERTICES];
	
	public void draw (Batch batch, float parentAlpha) 
	{
		final Color batchColor = batch.getColor();
		final float color = Color.toFloatBits(batchColor.r,
														  batchColor.g,
														  batchColor.b,
														  batchColor.a * parentAlpha);
		
		final float[] vertices = this.vertices;
		
		float y = this.y;
		for (int row = 0; row < rows; row++) 
		{
			float x = this.x;
			for (int col = 0; col < columns; col++) 
			{
				
				final TextureRegion region = tiles.get(data[row*columns + col]);
				
				float x1 = x;
				float y1 = y;
				float x2 = x1 + region.getRegionWidth();
				float y2 = y1 + region.getRegionHeight();

				float u1 = region.getU();
				float v1 = region.getV2();
				float u2 = region.getU2();
				float v2 = region.getV();

				vertices[X1] = x1;
				vertices[Y1] = y1;
				vertices[C1] = color;
				vertices[U1] = u1;
				vertices[V1] = v1;

				vertices[X2] = x1;
				vertices[Y2] = y2;
				vertices[C2] = color;
				vertices[U2] = u1;
				vertices[V2] = v2;

				vertices[X3] = x2;
				vertices[Y3] = y2;
				vertices[C3] = color;
				vertices[U3] = u2;
				vertices[V3] = v2;

				vertices[X4] = x2;
				vertices[Y4] = y1;
				vertices[C4] = color;
				vertices[U4] = u2;
				vertices[V4] = v1;

				batch.draw(region.getTexture(), vertices, 0, NUM_VERTICES);
				x += tileWidth;
			}
			y += tileHeight;
		}
	}
}
