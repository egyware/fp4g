package ${source.pckg};

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.apollo.GameState;
<#if source.imports??>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public class ${source.name} extends GameManager 
{
	public static final int Width  = ${width};
	public static final int Height = ${height};
	public final HashMap<String, Class<? extends GameState>> gameStates;
	
	public ${source.name}()
	{
		gameStates = new HashMap<String, Class<? extends GameState>>();
		<#if states?has_content>
		<#list states as state>
		gameStates.put("${state}", ${state}.class);
		</#list>
		</#if>
	}
	
	@Override
	public void create()
	{		
		super.create();
		Assets.initialize();
		
		<#if startState??>
		//iniciando el juego 
		${startState} _start = new ${startState}(this);     	
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
		Assets.dispose();
		super.dispose();		
	}
	
	public void onChangeLevel(String level)
	{
		try 
		{
			Class<?> state = Class.forName("${source.pckg}.".concat(level));
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