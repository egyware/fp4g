/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class On extends Value{
	private IScope local;
	private IScope code;
	//On Message SOURCE [...]
	public On(String _name,IScope local,IScope code) {
		super(_name);
		this.code = code;
		this.local = local;
	}
}
