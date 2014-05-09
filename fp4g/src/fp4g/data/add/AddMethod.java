/**
 * 
 */
package fp4g.data.add;

import fp4g.data.Add;
import fp4g.data.AddType;
import fp4g.data.DeclVar;
import fp4g.data.NameList;
import fp4g.data.define.Message;
import fp4g.data.expresion.IMap;

/**
 * Add especializado que permite añadir mensajes-metodos.
 * 
 * @author egyware
 *
 */
public class AddMethod extends Add
{	
	private final static String ATTACHINPUTPROCESOR = "attachInputProcessor";
	private final static String REPLACE = "replace";
	public final NameList nameList;
	
	private Message message;
	
	public AddMethod(String name, NameList list)
	{
		this(name, list, null);
	}
	
	public AddMethod(String name, NameList list, IMap values) 
	{	
		super(name, AddType.AddMethod, values);		
		this.nameList = list;
	}
	
	public void setMessage(Message message)
	{
		this.message = message;
	}
	public Message getMessage()
	{
		return message;
	}

	public boolean isAttachInputProcessor() 
	{
		if(values != null)
		{
			return (Boolean)values.get(ATTACHINPUTPROCESOR).getValue();
		}
		return false;
	}

	public String getReplace() 
	{
		if(values != null)
		{
			return (String)values.get(REPLACE).getValue();
		}
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("ADD %s(", name));
		final DeclVar last = nameList.last();
		for(DeclVar entry:nameList)
		{
			builder.append(entry.type.name());
			builder.append(' ');
			builder.append(entry.name);
			if(entry.initValue != null)
			{
				builder.append(" = ");
				builder.append(entry.initValue);
			}			
			if(entry != last)
			{
				builder.append(", ");
			}
		}
		builder.append(')');
		if(values != null)
		{
			builder.append(' ');
			builder.append(values);
		}
		else
		{
			builder.append(';');
		}
		return builder.toString();
	}
}
