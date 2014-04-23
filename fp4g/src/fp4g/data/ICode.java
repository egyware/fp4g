package fp4g.data;


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