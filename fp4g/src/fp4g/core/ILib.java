package fp4g.core;

import java.util.Collection;

import fp4g.core.Type;
import fp4g.data.IDefine;
import fp4g.data.expresion.IMap;
import fp4g.exceptions.DefineNotFoundException;


public interface ILib extends IMap
{
	
//	/**
//	 * Busca localmente un define por su nombre
//	 * @param name Nombre del define
//	 * @return el define buscado. Null si no lo encuentra. 
//	 */
//	public <T extends IDefine> T findDefine(String name);
//	
//	/**
//	 * Obtener un define sabiendo su tipo
//	 * @param defineType
//	 * @param defineName
//	 * @return
//	 */
//	public <T extends IDefine> T findDefine(DefineType defineType, String defineName);
//	
//	/**
//	 * Devuelve una colección de defines
//	 * @param defineType
//	 * @return
//	 */
//	public <T extends IDefine> Collection<T> getDefines(DefineType defineType);
//	public <T extends IDefine> Collection<T> getLocalDefines(DefineType defineType);
//	
//	/**
//	 * Pregunta si está la definicion
//	 * @param name
//	 * @return
//	 */
//	public <T extends IDefine> boolean isSetDefine(DefineType type,String name);
//	public <T extends IDefine> boolean isGlobalSetDefine(DefineType type, String name);
//	
//	/**
//	 * Busca una variable localmente
//	 * @param key
//	 * @return
//	 */
//	public IValue<?> find(String key);
//
//	public String getName();
//
//	/**
//	 * Busca un define localmente y luego busca en el padre en caso que no lo encuentre.
//	 * 
//	 * Si el define buscado no se encuentra, lanzará una excepción.
//	 *  
//	 * @param message
//	 * @param messageName
//	 * @return
//	 */
//	public <T extends IDefine> T getDefine(DefineType message, String messageName) throws DefineNotFoundException;
//
//	public <T extends IDefine> T getDefine(String whereName) throws DefineNotFoundException;
//
//	public <T extends IDefine> void setDefine(T define);

	public Type getType(String string);

	public void registerResolver(Resolver r);

	public void registerType(Type t);
		
}
