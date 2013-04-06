package fp4g.generator;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JExpression;

import fp4g.data.IScope;

public interface ScopeVisitor
{
	public void visitor(JExpression dataVar,JBlock block,IScope scope, String key, Object value);		
}