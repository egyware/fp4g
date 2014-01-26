package fp4g.generator.gdx.models;

import java.util.List;

import fp4g.generator.Model;

public class GameStateModel implements Model 
{
	private JavaCodeModel code;
	private List<ManagerModel> managers;
	private GameModel game;
	private List<String> builders;
	private List<AssetModel> assets;
	private boolean debug;
	private List<AddModel> entities;
	
	public final JavaCodeModel getCode() 
	{
		return code;
	}
	public final List<ManagerModel> getManagers() 
	{
		return managers;
	}
	public final GameModel getGame() 
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
	public final void setCode(JavaCodeModel clazz) 
	{
		this.code = clazz;
	}
	public final void setManagers(List<ManagerModel> managers) 
	{
		this.managers = managers;
	}
	public final void setGame(GameModel game) 
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
