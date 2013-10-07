package ${class.package};

//TODO parche, esto deberia estár en alguna clase de constantes o algo por el estilo..
import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class Utils {	
	private static CircleShape circleShape;
	private static PolygonShape boxShape;  
	private Utils(){}
	
	private static AssetManager assetManager;
	

	public static void initialize()
	{
		final InternalFileHandleResolver fileResolver = new InternalFileHandleResolver();
		assetManager = new AssetManager();
		//TODO talvez mas adelante, ir detectando que assets añadir o no...
		assetManager.setLoader(Sprite.class,new SpriteLoader(fileResolver));		
	}	
	
	public static void dispose()
	{
		if(circleShape != null)circleShape.dispose();
		if(boxShape != null)boxShape.dispose();
	}
	  
	public static <T> T getAsset(String asset) {
		return assetManager.get(asset);
	}
	public static Sprite getSprite(String asset)
	{
		return assetManager.get(asset);
	}
	public static TextureRegion getTexture(String asset)
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
	
	public static FixtureDef createCircle(int ratio)
	{
		if(circleShape == null)
		{
			circleShape = new CircleShape();
		}
		circleShape.setRadius(ratio*SCALE);
		
		FixtureDef fixture = new FixtureDef();
		fixture.shape = circleShape;		
		
		return fixture;
	}
	public static FixtureDef createBox(int w, int h)
	{
		if(boxShape == null)
		{
			boxShape = new PolygonShape();
		}
		boxShape.setAsBox(w*SCALE,h*SCALE);
				
		FixtureDef fixture = new FixtureDef();
		fixture.shape = boxShape;		
		
		return fixture;
	}
}