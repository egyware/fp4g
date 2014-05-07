package fp4g.generator.gdx.models;

public final class GameModel extends JavaSourceModel
{
	private String startState;
	private int width;
	private int height;

	public GameModel(String pckg, String name) 
	{
		super(new JavaMetaSourceModel(pckg,name));		
	}

	public void setStartState(String name)
	{
		startState = name;		
	}
	
	public String getStartState()
	{
		return startState;
	}

	public void setWidth(int width) 
	{
		this.width = width;		
	}
	public int getWidth() 
	{
		return width;		
	}

	public void setHeight(int height) 
	{
		this.height = height;		
	}
	public int getHeight() 
	{
		return height;		
	}

	
}
