/**
 * 
 */
package fp4g.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.apollo.managers.graphics.Sprite;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;

import fp4g.generator.Utils;
import fp4g.Log;
import static fp4g.Log.Show;



/**
 * @author egyware
 *
 */
public abstract class Function extends Value{
	private static HashMap<String,Class<? extends Function>> functions = new HashMap<String,Class<? extends Function>>();
		
	static
	{
		functions.put("getSprite" , GetSprite.class);
		functions.put("getSound"  , GetSound.class);
		functions.put("getMusic"  , GetMusic.class);
		functions.put("getTexture", GetTexture.class);
		functions.put("loadAssets", LoadAssets.class);
		
	}
	
	
	protected final Object args[];
	public Function(String name,Object _args[])
	{
		super (name);
		args = _args;		
	}
	/**
	 * Esta funcion tiene dos comportamientos especificos y depende que lo que devuelve
	 * <ol>
	 * <li>Si devuelve null, esta funcion es de tipo void y el codigo ya está agregado en el metodo</li>
	 * <li>Si devuelve una expresión, es porque espera que sea asignada en algún el codigo y debe agregarse según el generador actual</li>
	 * </ol> 
	 * @param _class
	 * @param addScope 
	 * @param block 
	 * @param _method
	 * @return
	 */
	public abstract JExpression call(JDefinedClass _class, JBlock block, IScope scope);
	
	public static Function buildFunction(String functionName,Object args[])
	{
		Class<? extends Function> _class = functions.get(functionName);
		if(_class == null)
		{
			return null;		
		}
		else
		{
			Function new_function = null;
			try {
				Constructor<? extends Function> c = _class.getConstructor(String.class,Object[].class);
				new_function = c.newInstance(functionName,args);
			} catch (SecurityException e) {
				e.printStackTrace();				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {				
				e.printStackTrace();
			} catch (InstantiationException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {				
				e.printStackTrace();
			} catch (InvocationTargetException e) {				
				e.printStackTrace();
			} 
			return new_function;
		}		
	}
	private static class GetSprite extends Function
	{

		public GetSprite(String name, Object[] _args) {
			super(name, _args);
			LoadAssets.addAssetToLoad((String)args[0],Sprite.class);
		}

		@Override
		public JExpression call(JDefinedClass _class,JBlock block,IScope scope) {
			Object value =  scope.superGet("name");
			try
			{
				String gameName = (String)value; //try get gameName
				JPackage _pack = Utils.getGamePackage();					
				JDefinedClass _game = _pack._getClass(gameName);
				
				JExpression expr = _game.staticInvoke("getAsset").arg((String)args[0]);
								
				return expr;			
			}
			catch(ClassCastException ex)
			{	
				Show(Log.ErrType.CannotCastVar,this);
				Show(Log.ErrType.CannotCastVar,value);				
				ex.printStackTrace();
			}			
			return null;			
		}
				
	}
	
	private static class LoadAssets extends Function
	{
		private static LoadAssets last_load;
		private static final JType[] _void = new JType[0];
		private HashMap<String,Class<?>> assets = new HashMap<String,Class<?>>();
		public LoadAssets(String name, Object[] _args) {
			super(name, _args);			
			last_load = this;
		}
		
		public static void addAssetToLoad(String asset, Class<?> _class)
		{
			last_load._addAssetToLoad(asset,_class);
		}
		private void _addAssetToLoad(String asset,Class<?> _class)
		{
			assets.put(asset,_class);
		}

		@Override
		public JExpression call(JDefinedClass _class, JBlock block,	IScope scope) {
			Object value = scope.superGet("name");
			try
			{				
				JCodeModel jcm = Utils.getJCM();
				JMethod load = _class.getMethod("load",_void);
				block = load.body();
				String gameName = (String)value;
				JPackage _pack = Utils.getGamePackage();					
				JDefinedClass _game = _pack._getClass(gameName);
				
				for(Entry<String, Class<?>> entry: assets.entrySet())
				{
					block.add(_game.staticInvoke("loadAsset").arg(entry.getKey()).arg(jcm.ref(entry.getValue()).staticRef("class")));
				}
//				JBlock disposeMethod = searchDispose(_class);
//				for(Entry<String, Class<?>> entry: assets.entrySet())
//				{
//					disposeMethod.add(_game.staticInvoke("unloadAsset").arg(entry.getKey()));
//				}
				block.staticInvoke(_game, "loadAssets");
				
			}catch(ClassCastException ex)
			{
				Show(Log.ErrType.ErrorCallFunction,this);
				Show(Log.ErrType.CannotCastVar,value);
				//ex.printStackTrace();
			}
			
			return null;
		}

//		private JBlock searchDispose(JDefinedClass _class) {
//			JBlock block = null;
//			for(final JMethod m:_class.methods())
//			{
//				if(m.name().equalsIgnoreCase("unload"))
//				{
//					block = m.body();
//				}
//			}
//			return block;
//		}
		
	}
	private static class GetSound extends Function
	{

		public GetSound(String name, Object[] _args) {
			super(name, _args);
			LoadAssets.addAssetToLoad((String)args[0],Sound.class);
		}

		@Override
		public JExpression call(JDefinedClass _class, JBlock block, IScope scope) {
			Object value = scope.superGet("name");
			try
			{
				String gameName = (String) value; //try get gameName
				JPackage _pack = Utils.getGamePackage();					
				JDefinedClass _game = _pack._getClass(gameName);
				
				JExpression expr = _game.staticInvoke("getAsset").arg((String)args[0]);
								
				return expr;			
			}
			catch(ClassCastException ex)
			{	
				Show(Log.ErrType.ErrorCallFunction,this);
				Show(Log.ErrType.CannotCastVar,value);
				
				//ex.printStackTrace();
			}			
			return null;
		}
		
	}
	private static class GetMusic extends Function
	{

		public GetMusic(String name, Object[] _args) {
			super(name, _args);		
			LoadAssets.addAssetToLoad((String)args[0],Music.class);
		}

		@Override
		public JExpression call(JDefinedClass _class, JBlock block, IScope scope) {
			Object value = scope.superGet("name");
			try
			{
				String gameName = (String)value; //try get gameName
				JPackage _pack = Utils.getGamePackage();					
				JDefinedClass _game = _pack._getClass(gameName);
				
				JExpression expr = _game.staticInvoke("getAsset").arg((String)args[0]);
								
				return expr;			
			}
			catch(ClassCastException ex)
			{				
				Show(Log.ErrType.ErrorCallFunction,this);
				Show(Log.ErrType.CannotCastVar,value);
			}			
			return null;
		}
		
	}
	private static class GetTexture extends Function
	{

		public GetTexture(String name, Object[] _args) {
			super(name, _args);		
			LoadAssets.addAssetToLoad((String)args[0],Texture.class);
		}

		@Override
		public JExpression call(JDefinedClass _class, JBlock block, IScope scope) {
			Object value = scope.superGet("name");
			try
			{
				String gameName = (String) value; //try get gameName
				JPackage _pack = Utils.getGamePackage();					
				JDefinedClass _game = _pack._getClass(gameName);
				
				JExpression expr = _game.staticInvoke("getAsset").arg((String)args[0]);
								
				return expr;			
			}
			catch(ClassCastException ex)
			{				
				Show(Log.ErrType.ErrorCallFunction,this);
				Show(Log.ErrType.CannotCastVar,value);
			}			
			return null;
		}
		
	}
}

