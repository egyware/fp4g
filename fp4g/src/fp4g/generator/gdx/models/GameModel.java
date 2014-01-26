package fp4g.generator.gdx.models;

import fp4g.generator.Model;

public class GameModel implements Model
{
	private int width;
	private int height;
	private String name;
	
	
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
