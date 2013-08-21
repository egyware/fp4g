package fp4g.data;

public abstract class Define extends Code{
	public ObjectType type;
	public String name;
	public Define parent;
	public NameList list;
	
	public Define(ObjectType type,String name)
	{
		this(type,name,null);
	}
	
	public Define(ObjectType type,String name, Define parent)
	{
		this.type = type;
		this.name = name;
		this.parent = parent;
	}
		
	public ObjectType getType()
	{
		return type;
	}	
	public String getName()
	{
		return name;
	}
	public void setNameList(NameList list) {
		this.list = list;		
	}	
	
	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public abstract void addADD(Add code);	
	/**
	 * Agrega una definición de codigo
	 * @param define
	 */
	public abstract void addDefine(Define define);
	/**
	 * Agrega un evento
	 * @param on
	 */
	public abstract void addOn(On on);
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public abstract boolean isDefined(ObjectType type,String name);
}
