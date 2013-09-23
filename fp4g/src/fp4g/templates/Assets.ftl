package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class Assets {
	private Assets(){}
	
	private static AssetManager assetManager;
	

	public static void initialize()
	{
		final InternalFileHandleResolver fileResolver = new InternalFileHandleResolver();
		assetManager = new AssetManager();
		//TODO talvez mas adelante, ir detectando que assets añadir o no...
		assetManager.setLoader(Sprite.class,new SpriteLoader(fileResolver));		
	}	
	  
	public static <T> T getAsset(String asset) {
		return assetManager.get(asset);
	}
	public static Sprite getSprite(String asset)
	{
		return assetManager.get(asset);
	}
	public static <T> void loadAsset(String asset, Class<T> clazz){
		assetManager.load(asset, clazz);
	}
	public static void unloadAsset(String asset){
		assetManager.unload(asset);
	}
	public static void loadAssets() { 
		assetManager.finishLoading();
	}
}