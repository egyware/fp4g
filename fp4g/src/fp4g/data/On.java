/**
 * 
 */
package fp4g.data;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.define.Message;
import fp4g.data.statements.Source;

/**
 * Es una sentencia que permite capturar un evento
 * @author egyware
 *
 */
public class On extends Container
{
	public final String name;
	public final Message message;
	public final List<Source> sources;
	//ON (Message[:filter] (...source...))+
	public On(IDefine current, Message message) 
	{
		super(current);
		this.message = message;
		this.name = message.name;
		sources = new LinkedList<Source>();
	}
	/**
	 * En caso que no exista un mensaje predefinido
	 * @param name
	 */
	public On(IDefine current, String name) 
	{
		super(current);
		this.message = null;
		this.name = name;
		sources = new LinkedList<Source>();
	}
	
	public Source addSource(Statements statements)
	{
		Source source = new Source(statements);
		sources.add(source);
		return source;
	}
}
