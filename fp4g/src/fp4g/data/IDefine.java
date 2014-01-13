package fp4g.data;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.Map;
import fp4g.exceptions.DefineNotFoundException;

public interface IDefine extends ILib, ICode, Map
{
	public DefineType getType();
	public String getName();
	public On getOn(String messageName);
	public IDefine getParent();
	
	/**
	 * Agrega una definición de codigo
	 * @param define
	 */	
	public <T extends IDefine> void setDefine(T define);
	/**
	 * Agrega un evento
	 * @param on
	 */
	public void setOn(On on);

	
	/**
	 * Busca un define de tipo desconocido
	 * @param name Nombre de la definición
	 * @return Define La definición buscada, si no devuelve null
	 * @throws DefineNotFoundException 
	 */
	public <T extends IDefine> T getDefine(String defineName) throws DefineNotFoundException;
	
	/**
	 * Obtiene una definición
	 * @param name
	 * @return
	 * @throws DefineNotFoundException 
	 */	
	public <T extends Define> T getDefine(DefineType type,String name) throws DefineNotFoundException;
	
	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public void setAdd(Add add);
	

	/**
	 * Devuelve todas las variables de tiene almacenado este define
	 * @return
	 */
	public void set(String key, Literal<?> eval);
	
	
}
