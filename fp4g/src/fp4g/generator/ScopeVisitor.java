package fp4g.generator;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JExpression;

import fp4g.data.Scope;

public interface ScopeVisitor
{
	public void visitor(JExpression dataVar,JBlock block,Scope scope, String key, Object value);		
}