/**
 * 
 */
package fp4g.data;

import java.util.Map.Entry;

/**
 * @author egyware
 *
 */
public final class ArrayScope implements IScope {

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public void set(String key, Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#add(java.lang.Object)
	 */
	@Override
	public void add(Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#getLastInsert()
	 */
	@Override
	public int getLastInsert() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#writeAndOverride(fp4g.data.IScope)
	 */
	@Override
	public void writeAndOverride(IScope other) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#writeWithoutOverride(fp4g.data.IScope)
	 */
	@Override
	public void writeWithoutOverride(IScope other) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#toArray()
	 */
	@Override
	public Entry<String, Object>[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#localGet(java.lang.String)
	 */
	@Override
	public Object localGet(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#superGet(java.lang.String)
	 */
	@Override
	public Object superGet(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#clone()
	 */
	public IScope clone() throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
