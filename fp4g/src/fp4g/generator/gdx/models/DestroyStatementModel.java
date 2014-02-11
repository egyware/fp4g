package fp4g.generator.gdx.models;

import fp4g.data.statements.Destroy;


public final class DestroyStatementModel extends StatementModel 
{		
	public String destroyTo;
	
	public DestroyStatementModel(Destroy destroy) {
		super(StatementModel.Type.DestroyStatement);
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
