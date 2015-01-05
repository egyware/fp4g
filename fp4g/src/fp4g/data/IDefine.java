package fp4g.data;
import java.util.List;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.add.AddDefine;
import fp4g.data.add.AddMethod;
import fp4g.data.expresion.IMap;
import fp4g.data.operators.IAccessible;

public interface IDefine extends ICode, IMap, IValue<IDefine>, IAccessible, Expresion
{
	public DefineType getType();
	/**
	 * Devuelve el nombre de este Define
	 * 
	 */
	public String getName();	
	
	public On getOn(String messageName);
		
	/**
	 * Agrega una captura de un evento
	 * @param on
	 */
	public void setOn(On on);

	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public void setAdd(Add add);
	
	public ILib getLibrary();
	
	public void addFlags(NameList flags);
	public NameList getFlags();
	public void addWhen(Expresion expresion, Statement statement);
	public List<AddDefine> getAddDefines(DefineType behavior);
	
	public IValue<?> find(String key);
	public Add findAddDefineByName(String name);
	public AddMethod getAddMethod(String addName);
}
