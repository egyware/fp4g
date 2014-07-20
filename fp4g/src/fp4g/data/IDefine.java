package fp4g.data;
import fp4g.data.expresion.IMap;

public interface IDefine extends ICode, IMap, IValue<IDefine>
{
	public DefineType getType();
	/**
	 * Devuelve el nombre de este Define
	 * 
	 */
	public String getName();	
	
	public On getOn(String messageName);
		
	/**
	 * Agrega una captura de un evento
	 * @param on
	 */
	public void setOn(On on);

	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public void setAdd(Add add);
	
	public ILib getLibrary();
}
