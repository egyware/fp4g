package ${class.package};

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.apollo.GameState;
<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name} extends GameManager {
	public static final int Width  = ${width};
	public static final int Height = ${height};
	
	@Override
	public void create()
	{		
		super.create();
		Utils.initialize();
		
		<#if start_state??>
		//iniciando el juego 
		${start_state} _start = new ${start_state}(this);     	
		nextState(_start);
		<#else>
		throw new RuntimeException("¿Se te olvido usar start?");
    	</#if>	
	}
	
	@Override 
	public void resize(int w,int h)
	{
		
	}
    
	@Override
	public void dispose()
	{
		Utils.dispose();
		super.dispose();		
	}
	
	public void onChangeLevel(String level)
	{
		try 
		{
			Class<?> state = Class.forName("${class.package}.".concat(level));
			Constructor<?> constructor = state.getConstructor(GameManager.class);
			GameState gameState = (GameState) constructor.newInstance(this);
			nextState(gameState);
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onReloadLevel()
	{		
	}
	
	
}