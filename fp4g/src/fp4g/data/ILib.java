package fp4g.data;

import java.util.Collection;

import fp4g.data.define.Game;
import fp4g.data.expresion.IMap;


public interface ILib extends IMap, IValue<ILib>
{
	
	/**
	 * Busca localmente un define por su nombre
	 * @param name Nombre del define
	 * @return el define buscado. Null si no lo encuentra. 
	 */
	public <T extends IDefine> T findDefine(String name);
	
	/**
	 * Obtener un define sabiendo su tipo
	 * @param defineType
	 * @param defineName
	 * @return
	 */
	public <T extends IDefine> T findDefine(DefineType defineType, String defineName);
	
	/**
	 * Devuelve una colección de defines
	 * @param defineType
	 * @return
	 */
	public <T extends IDefine> Collection<T> getDefines(DefineType defineType);
	public <T extends IDefine> Collection<T> getLocalDefines(DefineType defineType);
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public <T extends IDefine> boolean isSetDefine(DefineType type,String name);
	
	/**
	 * Busca una variable localmente
	 * @param key
	 * @return
	 */
	public IValue<?> find(String key);

	public String getName();

	/**
	 * Busca un define localmente y luego busca en el padre en caso que no lo encuentre.
	 * 
	 * Si el define buscado no se encuentra, lanzará una excepción.
	 *  
	 * @param message
	 * @param messageName
	 * @return
	 */
	public <T extends IDefine> T getDefine(DefineType message, String messageName);

	public <T extends IDefine> T getDefine(String whereName);

	public <T extends IDefine> void setDefine(T define);

	public Game getGame();
	

}
