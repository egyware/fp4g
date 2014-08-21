package fp4g.classes;

import fp4g.data.expresion.ArrayList;



/**
 * Clase que administra codigo adicional necesario para hacer funcionar un manager
 * @author Edgardo
 *
 */
public class ManagerData
{
	private String setMethod = "Manager";
	private ArrayList preInitialize;
	private ArrayList postInitialize;
	private ArrayList params;
	private ArrayList preUpdate;
	private ArrayList postUpdate;
	private ArrayList fields;
	private ArrayList imports; //!< Solo use en modo depuración
	
	public ManagerData()
	{
	}

	public final String getSetMethod() {
		return setMethod;
	}

	public final ArrayList getPreInitialize() {
		return preInitialize;
	}

	public final ArrayList getPostInitialize() {
		return postInitialize;
	}

	public final ArrayList getParams() {
		return params;
	}

	public final ArrayList getPreUpdate() {
		return preUpdate;
	}

	public final ArrayList getPostUpdate() {
		return postUpdate;
	}

	public final ArrayList getFields() {
		return fields;
	}

	public final void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}

	public final void setPreInitialize(ArrayList preInitialize) {
		this.preInitialize = preInitialize;
	}

	public final void setPostInitialize(ArrayList postInitialize) {
		this.postInitialize = postInitialize;
	}

	public final void setParams(ArrayList params) {
		this.params = params;
	}

	public final void setPreUpdate(ArrayList preUpdate) {
		this.preUpdate = preUpdate;
	}

	public final void setPostUpdate(ArrayList postUpdate) {
		this.postUpdate = postUpdate;
	}

	public final void setFields(ArrayList fields) {
		this.fields = fields;
	}

	public ArrayList getImports() {
		return imports;
	}

	public void setImports(ArrayList imports) {
		this.imports = imports;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();		
		builder.append("ManagerData");
		builder.append(" { ... }");
		
		return builder.toString();
	}

	
}
