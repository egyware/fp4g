package fp4g.data;

import java.util.Collection;

public interface ILib 
{
	/**
	 * Obtener un define por nombre
	 * @param defineName
	 * @return
	 */
	public <T extends Define> T getDefine(String defineName);
	
	/**
	 * Obtener un define sabiendo su tipo
	 * @param defineType
	 * @param defineName
	 * @return
	 */
	public <T extends Define> T getDefine(DefineType defineType, String defineName);
	
	/**
	 * Devuelve una colección de defines
	 * @param defineType
	 * @return
	 */
	public <T extends Define> Collection<T> getDefines(DefineType defineType);

}
