package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name} extends GameManager {
	public static final int Width  = ${width};
	public static final int Height = ${height};

	private static AssetManager assetManager;
	private InternalFileHandleResolver fileResolver;

	@Override
	public void create()
	{
		super.create();
		fileResolver = new InternalFileHandleResolver();
		assetManager = new AssetManager();
		assetManager.setLoader(Sprite.class,new SpriteLoader(fileResolver));		
	}
	
	@Override 
	public void resize(int w,int h)
	{
		<#if start_state??>
		//iniciando el juego 
		${start_state} _start = new ${start_state}(this);     	
		start(_start);
		<#else>
		throw new RuntimeException("¿Se te olvido usar start?");
    	</#if>
	}
    
	@Override
	public void dispose()
	{
		super.dispose();
	}
    
	//funciones de utilidad  
	public static <T> T getAsset(String asset) {
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