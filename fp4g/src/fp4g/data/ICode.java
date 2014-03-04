package fp4g.data;

public interface ICode extends ILine
{

	public abstract void setGenerable(boolean b);
	public abstract void setUsable(boolean b);

	public abstract boolean isGenerable();
	public abstract boolean isUsable();

}