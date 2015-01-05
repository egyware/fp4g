package fp4g.generator.gdx;

import java.util.LinkedList;
import java.util.List;

import fp4g.core.Expresion;
import fp4g.data.Container;
import fp4g.data.Statement;
import fp4g.data.Statements;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.FP4GException;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;

public class JavaStatementBuilder {
	private JavaGenerator generator;

	public JavaStatementBuilder(JavaGenerator generator) {
		this.generator = generator;
	}

	public List<String> generateStatements(JavaMetaSourceModel model,Container container, Statements stmnts) throws FP4GException 
	{
		LinkedList<String> statements = new LinkedList<String>();
		for (Statement stmnt : stmnts) 
		{
			if(stmnt instanceof FunctionCall)
			{
				try
				{
					Expresion resultExpr = generator.function(model, container, (FunctionCall)stmnt);
					statements.add(generator.expresion(model, container, resultExpr));
				}
				catch(CannotEvalException e)
				{
					Log.Exception(e,stmnt.getLine());
				}
			}
			
//			switch(stmnt.statementType)
//			{
//			case Assignment:
//			{
//				Assignment assignment = (Assignment)stmnt;				
//				AssignmentModel assignmentModel = new AssignmentModel(assignment.varName,generator.expresion(model, assignment.expresion));
//				statements.add(assignmentModel);
//			}
//				break;
//			case Subscribe:
//			{
//				final On on = (On)container;
//				Subscribe subscribe = (Subscribe) stmnt;
//				SubscribeStatementModel subscribeModel = new SubscribeStatementModel(subscribe, on.message.isFactory());
//				statements.add(subscribeModel);
//
//				try 
//				{
//					Depend resolve = generator.resolveDependency(subscribe.instance);
//					resolve.perform(subscribe.instance, model);
//				} catch (DependResolverNotFoundException e1) 
//				{
//					Log.Exception(e1, subscribe.getLine());
//				}
//
//				try 
//				{
//					Depend resolve = generator.resolveDependency(subscribe.message);
//					resolve.perform(subscribe.message, model);
//				} 
//				catch (DependResolverNotFoundException e1) 
//				{
//					Log.Exception(e1, subscribe.getLine());
//					model.addRequireSource("com.apollo.message.".concat(
//							subscribe.message.name).concat("Message"));
//				}
//			}
//				break;
//			case Unsubscribe:
//			{
//				final On on = (On)container;
//				Unsubscribe unsubscribe = (Unsubscribe) stmnt;
//				SubscribeStatementModel subscribeModel = new SubscribeStatementModel(unsubscribe, on.message.isFactory());
//				statements.add(subscribeModel);
//
//				try 
//				{
//					Depend resolve = generator.resolveDependency(unsubscribe.instance);
//					resolve.perform(unsubscribe.instance, model);
//				}
//				catch (DependResolverNotFoundException e1) 
//				{
//					Log.Exception(e1, unsubscribe.getLine());
//				}
//
//				try 
//				{
//					Depend resolve = generator.resolveDependency(unsubscribe.message);
//					resolve.perform(unsubscribe.message, model);
//				}
//				catch (DependResolverNotFoundException e1)
//				{
//					Log.Exception(e1, unsubscribe.getLine());
//					model.addRequireSource("com.apollo.message.".concat(
//							unsubscribe.message.name).concat("Message"));
//				}
//			}
//				break;
//			}			
		}
		return statements;
	}

}
