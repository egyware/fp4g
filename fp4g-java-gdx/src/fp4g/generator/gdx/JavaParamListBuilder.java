package fp4g.generator.gdx;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.Container;
import fp4g.data.DeclVar;
import fp4g.data.Define;
import fp4g.data.ILib;
import fp4g.data.NameList;
import fp4g.data.VarType;
import fp4g.data.vartypes.BasicType;
import fp4g.data.vartypes.CustomType;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.VarCodeModel;
import fp4g.log.FP4GError;
import fp4g.log.Log;



public class JavaParamListBuilder  
{
	private final JavaGenerator generator;
	private final ILib lib;
	public JavaParamListBuilder(ILib lib,JavaGenerator generator)
	{
		this.lib = lib;
		this.generator = generator;
	}
	
	public List<VarCodeModel> build(NameList nameList, Container container, JavaMetaSourceModel model) 
	throws DependResolverNotFoundException, CannotEvalException
	{
		//lo veo un poco consumidor de recursos, pero bueno...
		List<VarCodeModel> pair = new LinkedList<VarCodeModel>();
		for(DeclVar par: nameList)
		{		
			String name = translateType(par.type,model);
			VarCodeModel param;
			if(par.initValue != null)
			{
				param = new VarCodeModel(name, par.name,generator.expresion(model, container, par.initValue));					
			}
			else
			{
				param = new VarCodeModel(name,par.name);
			}								
			pair.add(param);
		}
		return pair;
	}
	
	public List<VarCodeModel> buildForMessage(NameList nameList, JavaMetaSourceModel model) 
			throws DependResolverNotFoundException, CannotEvalException
			{
				//lo veo un poco consumidor de recursos, pero bueno...
				List<VarCodeModel> pair = new LinkedList<VarCodeModel>();
				for(DeclVar par: nameList)
				{	
					final String name;
					final VarType type = par.type;
					String method = null;
					if(type instanceof BasicType)
					{
						switch((BasicType)type)
						{
							case Number:								
								name = translateType(BasicType.Number,model);
								break;
							case Float:
								method = "floatValue";
								name = translateType(BasicType.Number,model);
								break;
							case Double:
								method = "doubleValue";
								name = translateType(BasicType.Number,model);
								break;
							case Integer:
								method = "intValue";
								name = translateType(BasicType.Number,model);
								break;							
							default:
								name = translateType(par.type,model);
							break;
						}
					}else
					{
						name = translateType(par.type,model);
					}
					
					VarCodeModel param = new VarCodeModel(name,par.name,method);
					pair.add(param);
				}
				return pair;
			}

	public String translateType(VarType type, JavaMetaSourceModel model) 
	throws DependResolverNotFoundException
	{
		String name;
		if(type instanceof BasicType)
		{
			switch((BasicType)type)
			{
			case Bool:
				name = "boolean";
				break;		
			case Number:
				name = "Number";
				break;
			case String:
				name = "String";
				break;
			case Double:
				name = "double";
				break;
			case Float:
				name = "float";
				break;
			case Integer:
				name = "int";
				break;		
			default:
				throw new FP4GRuntimeException(FP4GError.IllegalState,"Estado no valido del generador");
			}
		}
		else
		{
			CustomType custom = (CustomType)type;
			try
			{
				Define define = lib.getDefine(custom.type, custom.name);
				generator.resolveDependency(define).perform(define, model);
			}
			catch(DefineNotFoundException e)
			{
				Log.Exception(e);
			}
			catch(DependResolverNotFoundException e)
			{
				Log.Exception(e);
			}
			name = custom.name;
		}
		return name;
	}
	

}
