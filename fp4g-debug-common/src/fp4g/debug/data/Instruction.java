package fp4g.debug.data;

public enum Instruction 
{
	//to game
	SendMessage,
	LoadState,
	NextState,
	CreateEntity,
	AddEntity,	
	Pop,	
	
	//to client
	AddedEntity,
	RemovedEntity,
	Entities,
	
}
