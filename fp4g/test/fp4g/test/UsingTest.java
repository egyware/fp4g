/**
 * 
 */
package fp4g.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.BeforeClass;
import org.junit.Test;

import fp4g.data.Define;
import fp4g.data.ILib;
import fp4g.data.add.AddMethod;
import fp4g.data.libs.Lib;
import fp4g.data.libs.LibContainer;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;

/**
 * @author Edgardo
 *
 */
public class UsingTest {
	private static ILib local;
	private final static String[] libCode =
		{
			"DEFINE GAME",
			"[",
			"SET methods = EMPTY AS MessageMethods;",
			"]"					
		};
	private final static String[] code =
		{
			"USING MESSAGE TestA;",
			"USING MESSAGE TestB[]",
			"USING MESSAGE TestC",
			"[",
			"ADD Metodo1(Integer a, Integer b);",
			"ADD Metodo2(Integer a, Integer b);",
			"]",
			"DEFINE GAME Test ",
			"[",
			"]",
		};
	
		
			
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass()
	throws Exception 
	{
		LibContainer container = new LibContainer();		
		{
			Lib lib = new Lib(container);
			FP4GLexer lexer = new FP4GLexer(new ANTLRInputStream(toOneString(libCode)));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);			
			
			ParseTree tree = p.gameLib();			
			if(tree != null)
			{
				FP4GDataVisitor visitor = new FP4GDataVisitor(lib);
				visitor.visit(tree);
			}
			else
			{
				fail("Biblioteca no cargada");			
			}
			container.addLib(lib);
			local = lib;
		}
		
		FP4GLexer lexer = new FP4GLexer(new ANTLRInputStream(toOneString(code)));	
		CommonTokenStream tokens = new CommonTokenStream(lexer);		
		FP4GParser p = new FP4GParser(tokens);		
		p.setBuildParseTree(true);			
		
		ParseTree tree = p.program();			
		if(tree != null)
		{
			Lib lib = container.getLocal();
			FP4GDataVisitor visitor = new FP4GDataVisitor(lib);
			visitor.visit(tree);			
		}
		else
		{
			fail("Biblioteca no cargada");			
		}
	}

	private static String toOneString(String[] array) {
		StringBuilder builder = new StringBuilder();
		for(String c:array)
		{
			builder.append(c);
		}
		return builder.toString();
	}

	@Test
	public void testUsing() 
	{
		try 
		{
			Define testA = local.getDefine("TestA");
		
			Define testB = local.getDefine("TestB");
			Define testC = local.getDefine("TestC");
			
			assertTrue("TestA no puede ser Generable", testA.isGenerable() == false);
			assertTrue("TestA debe ser usable",        testA.isUsable()    == true);
			
			assertTrue("TestB no puede ser Generable", testB.isGenerable() == false);
			assertTrue("TestB debe ser usable",        testB.isUsable()    == true);
			
			assertTrue("TestC no puede ser Generable", testC.isGenerable() == false);
			assertTrue("TestC debe ser usable",        testC.isUsable()    == true);		
		}
		catch (DefineNotFoundException e) 
		{
			fail(e.toString());
		}
	}
	
	@Test
	public void testUsingMessageMethod() 
	{
		try
		{
			Define testC = local.getDefine("TestC");
			
			AddMethod m1 = testC.getAddMethod("Metodo1");
			AddMethod m2 = testC.getAddMethod("Metodo2");
		
			assertNotNull("M1 No puede ser null",m1);
			assertNotNull("M1 No puede ser null",m2);
		}
		catch (DefineNotFoundException e) 
		{
			fail(e.toString());
		}
	}
}
