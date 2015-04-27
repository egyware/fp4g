package com.apollo;

public interface Family 
{
	/**
	 * Devuelve el nombre de esta entidad.
	 * @return
	 */
	String getName();
	
	/**
	 * Esta funcion sirve para revisar si una instancia de familia es padre de otra o no. 
	 * Por conveniencia una instancia es padre de si misma.
	 * 
	 * @param child Posible hijo
	 * @return Devuelve <code>true</code> si <code>child</code> es hijo de esta instancia. Si <code>child</code> es esta misma instancia devolverá <code>true</code>. Si no devolverá <code>false</code>.
	 */
	boolean isParentsTo(Family child);
}
