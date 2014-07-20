package fp4g.data;

import java.util.Collection;

import fp4g.data.expresion.IMap;


public interface ILib extends IMap
{
	
	/**
	 * Obtener un define por nombre
	 * @param defineName
	 * @return
	 */
	public <T extends IDefine> T findDefine(String defineName);
	
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
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public <T extends IDefine> boolean isSetDefine(DefineType type,String name);

	public String getName();

	public <T extends IDefine> T getDefine(DefineType message, String messageName);

	public <T extends IDefine> T getDefine(String whereName);

	public <T extends IDefine> void setDefine(T define);
	

}
