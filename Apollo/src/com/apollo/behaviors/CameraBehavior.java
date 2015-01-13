package com.apollo.behaviors;
import com.apollo.BaseBehavior;
import com.badlogic.gdx.math.Vector2;
import com.egysoft.gdx.Game;

/**
  * Autogenerado por FP4G
  * [NO MODIFICAR]
  * 14:47:37
  */
public class CameraBehavior extends BaseBehavior
{
	private static final int screen_width2  = Game.Width/2;
	private static final int screen_height4 = Game.Height/2;

	public int xo, yo, w, h;	
	public CameraBehavior(int xo,int yo, int w, int h)
	{
		this.xo=xo;
		this.yo=yo;
		this.w = w;
		this.h = h;
	}
	
	//esta entidad camara se hace activa y obtiene la primera vez una camara, update en primera instancia no funcionará	
	public void setCamera(Vector2 position, float x, float y) 
	{
		if(x <= xo + screen_width2)			
		{
			position.x = xo + screen_width2;
		}
		if(x > xo + w - screen_width2)
		{
			position.x = xo + w - screen_width2;
		}
		if (y <= yo + screen_height4) 
		{
			position.y = yo + screen_height4;
		}
		if(y > yo + h - screen_height4)
		{
			position.y = yo + h - screen_height4;
		}		
	}	
	
	public void update(float x)
	{
//		shapeRenderer.setProjectionMatrix(camera.combined);
//		 
//		shapeRenderer.begin(ShapeType.Filled);
//		//shapeRenderer.setColor(1, 1, 0, 0.5f);
//		//shapeRenderer.rect(xo, yo, xo+w, yo+h);
//		shapeRenderer.setColor(0.68f, 1, 1,0.5f);		
//		shapeRenderer.rect(xo+screen_width2, yo+screen_height4 , w-screen_width2, h-screen_height4 );
//		shapeRenderer.end();
//		
//		shapeRenderer.begin(ShapeType.Line);
//		shapeRenderer.setColor(0, 0.9f, 0, 1);
//		shapeRenderer.rect(xo, yo, xo+w, yo+h);
//		shapeRenderer.rect(xo+screen_width2, yo+screen_height4 , w-screen_width2, h-screen_height4 );
//		shapeRenderer.end();
	}
	
	//actualiza la camara
	public void update(Vector2 position, float x, float y) 
	{
		if(xo + screen_width2 <= x && x < xo + w - screen_width2)
		{
			position.x = x;
		}
		if (yo + screen_height4 <= y && y < yo + h - screen_height4)
		{
			position.y = y;
		}		
	}
	
	public boolean inZone(float x, float y)
	{		
		return (xo <= x && x < xo + w) && (yo <= y && y < yo + h);
	}
}