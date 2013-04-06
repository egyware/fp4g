package fp4g.data;

import java.util.Map.Entry;

public interface IScope extends Cloneable {
	

	public void set(String key, Object value);

	public void add(Object value);

	public int getLastInsert();

	/**
	 * Copia y sobreescribe de este scope a otro
	 * @param other El Scope donde se sobreescribiran los datos
	 * @see writeWithoutOverride
	 */
	public void writeAndOverride(IScope other);

	/**
	 * Copia hacia el otro, pero no sobreescribe las propiedades definidas en el otro Scope hacia este scope
	 * @param other Otro Scope donde se escribiran los datos faltantes 
	 * @see writeAndOverride
	 */
	public void writeWithoutOverride(IScope other);

	public IScope clone() throws CloneNotSupportedException;

	public Entry<String, Object>[] toArray();

	public int size();
	
	/**
	 * Obtiene un valor, si este no es encontrado busca en uno superior.
	 * @param key Llave del valor a buscar
	 * @return El objeto asociado a la llave, si no lo encuentra devuelve null
	 */
	public Object get(String key);

	public Object localGet(String string);

	public Object superGet(String string);

}