package fp4g.generator.gdx.models;

import java.util.List;

public class GameStateModel extends JavaSourceModel
{
	private List<ManagerModel> managers;
	private GameFragment game;
	private List<String> builders;
	private List<AssetModel> assets;
	private boolean debug;
	private List<AddModel> entities;
	
	public GameStateModel(String pckg, String name) 
	{
		super(new JavaMetaSourceModel(pckg,name));
		
	}
	
	public final List<ManagerModel> getManagers() 
	{
		return managers;
	}
	public final GameFragment getGame() 
	{
		return game;
	}
	public final List<String> getBuilders() 
	{
		return builders;
	}
	public final List<AssetModel> getAssets() 
	{
		return assets;
	}
	
	public final void setManagers(List<ManagerModel> managers) 
	{
		this.managers = managers;
	}
	
	public final void setGame(GameFragment game) 
	{
		this.game = game;
	}	
	public final void setBuilders(List<String> builders) 
	{
		this.builders = builders;
	}
	public final void setAssets(List<AssetModel> assets) 
	{
		this.assets = assets;
	}
	public final boolean isDebug() {
		return debug;
	}
	public final void setDebug(boolean debug) {
		this.debug = debug;
	}
	public final List<AddModel> getEntities() {
		return entities;
	}
	public final void setEntities(List<AddModel> entities) {
		this.entities = entities;
	}
}
