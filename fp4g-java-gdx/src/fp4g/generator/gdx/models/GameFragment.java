package fp4g.generator.gdx.models;

import fp4g.generator.Fragment;

public class GameFragment implements Fragment
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
	@Override
	public String getFragmentName() 
	{
		return GameFragment.class.getSimpleName();
	}	
}
