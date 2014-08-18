package fp4g.data;

import java.util.HashMap;

import fp4g.data.define.Asset;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Goal;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.define.Struct;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

/**
 * Esta clase tiene la utilidad de almacenar las diferentes constantes de los posibles tipos de datos que pueden haber en el generador.
 * 
 * @author Edgardo
 */
public class DefineTypes
{
	private static class DefineBasicType implements DefineType 
	{
		private final Class<? extends IDefine> defineClass;		
		
		private DefineBasicType(final Class<? extends IDefine> clazz)
		{
			defineClass = clazz;
		}
		
		@Override
		public Class<? extends IDefine> getDefineClass() 
		{
			return defineClass;
		}

		@Override
		public String name()
		{
			return defineClass.getSimpleName();
		}
		
		@Override
		public String toString()
		{
			return String.format("DefineType(%s)",name());
		}
	}

	public static final DefineType GAME     = new DefineBasicType(Game.class);
	public static final DefineType STATE    = new DefineBasicType(GameState.class);
	public static final DefineType MANAGER  = new DefineBasicType(Manager.class);
	public static final DefineType ASSET    = new DefineBasicType(Asset.class);
	public static final DefineType BEHAVIOR = new DefineBasicType(Behavior.class);
	public static final DefineType ENTITY   = new DefineBasicType(Entity.class);
	public static final DefineType GOAL     = new DefineBasicType(Goal.class);
	public static final DefineType MESSAGE  = new DefineBasicType(Message.class);
	public static final DefineType STRUCT   = new DefineBasicType(Struct.class);
	
	private static final HashMap<String, DefineType> types = new HashMap<String, DefineType>();
	
	static
	{
		registerType(GAME);
		registerType(STATE);
		registerType(MANAGER);
		registerType(ASSET);
		registerType(BEHAVIOR);
		registerType(ENTITY);
		registerType(GOAL);
		registerType(MESSAGE);
		registerType(STRUCT);
	}
	
	public static void registerType(DefineType type)
	{
		types.put(type.name().toUpperCase(), type);
	}
	
	public static DefineType[] values()
	{
		DefineType values[] = new DefineType[types.size()];
		types.values().toArray(values);
		return values;
	}
	
	public static DefineType getDefineTypeByName(String name)
	{
		DefineType type = types.get(name);
		if(type == null)
		{
			throw new FP4GRuntimeException(FP4GError.DefineTypeNotFound,name);
		}
		return type;
	}
	
}
