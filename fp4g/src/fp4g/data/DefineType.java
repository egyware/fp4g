package fp4g.data;

import fp4g.data.define.Asset;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Goal;
import fp4g.data.define.Manager;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Message;
import fp4g.data.define.Struct;

//están ordenados
public enum DefineType
{
	GAME(Game.class),
	STATE(GameState.class),
	MANAGER(Manager.class),
	ASSET(Asset.class),
	BEHAVIOR(Behavior.class),
	ENTITY(Entity.class),
	GOAL(Goal.class),
	MESSAGE(Message.class),
	STRUCT(Struct.class)
	;
	
	//talvez incluir esta variable adicional, sea demasiado, pero servirá de pista para más adelante cuando se quiere usar cualquier tipo de define.
	//Ok, lo vas a olvidar. Crea una interface publicando los metodos para acceder a esta variable. Luego utiliza a tu antojo esta clase. Algo parecido a Message/MessageHandler
	private Class<? extends IDefine> define;
	private DefineType(Class<? extends IDefine> define)
	{
		this.define = define;		
	}
	
	public Class<? extends IDefine> getDefineClass()
	{
		return define;
	}
}
