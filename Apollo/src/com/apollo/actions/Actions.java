package com.apollo.actions;

import com.apollo.Action;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

/**
 * Mi propia versión LIGERAMENTE alterada de gdx.Actions
 * @author Edgardo
 *
 */
public class Actions
{
	public static <T extends Action> T action (Class<T> type) {
		Pool<T> pool = Pools.get(type);
		T action = pool.obtain();
		action.setPool(pool);
		return action;
	}
	
	public static SequenceAction sequence(Action ...actions) 
	{
		SequenceAction sequence = action(SequenceAction.class);
		for(Action action:actions)
		{
			sequence.addAction(action);
		}
		return sequence;
	}
	
	
	
	private Actions()
	{		
	}

}
