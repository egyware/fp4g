package fp4g.generator.gdx.models;

import fp4g.data.Statement;
import fp4g.data.statements.Destroy;
import fp4g.generator.StatementModel;


public final class DestroyStatementModel extends StatementModel 
{		
	public String destroyTo;
	
	public DestroyStatementModel(Destroy destroy) {
		super(Statement.Type.Destroy);
		switch(destroy.toDestroy)
		{
		case Other:
			destroyTo = "other"; //if exists
			break;
		case Self:
			destroyTo = "this";
			break;		
		default:
			//TODO throw error
			break;		
		}
	}	
	
	public String getDestroyTo()
	{
		return destroyTo;
	}
	
	
	
}
