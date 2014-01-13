package fp4g.data;

import java.util.Collection;


public interface ILib
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

}
