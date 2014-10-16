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
		assets.dispose();
		super.dispose();		
	}
	
	public void onChangeLevel(String level)
	{
		try 
		{
			Class<? extends GameState> state = gameStates.get(level);
			if(state == null)
			{
				//TODO throw error
			}			
			Constructor<? extends GameState> constructor = state.getConstructor(GameManager.class);
			GameState gameState = constructor.newInstance(this);
			nextState(gameState);
		} 
		catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onReloadLevel()
	{		
	}
	
	public int getWidth()
	{
		return Width;
	}
	public int getHeight()
	{
		return Height;
	}	
	
}