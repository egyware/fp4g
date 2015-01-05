package fp4g.data;

import fp4g.core.ILine;


/**
 * Especifica si la clase se puede generar o debe usar un archivo externo. 
 * 
 * @author Edgardo
 *
 */
public interface ICode extends ILine
{

	public abstract void setGenerable(boolean b);
	public abstract void setUsable(boolean b);

	public abstract boolean isGenerable();
	public abstract boolean isUsable();

}