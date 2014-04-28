package fp4g.generator.gdx.models.On;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.AddMethod;
import fp4g.generator.Model;
import fp4g.generator.gdx.models.ParamCodeModel;

public final class MethodHandlerModel implements Model
	{
		//que necesito ac�, por cada MethodHander necesito:
		//Nombre del metodo
		private final String name;		
		//Una lista de Source Codes
		private final List<SourceModel> sources;
		//Parametros
		private final List<ParamCodeModel> params;
		//Se requiere attach?
		private final boolean attachMethod;
				
		public MethodHandlerModel(AddMethod method, List<ParamCodeModel> p)
		{
			name = method.name;
			params = p;
			sources = new LinkedList<SourceModel>();
			attachMethod = method.isAttachInputProcessor();
		}	

		public String getName() 
		{
			return name;
		}
		public List<SourceModel> getSources()
		{
			return sources;
		}
		
		public void addSource(SourceModel source) 
		{
			sources.add(source);			
		}
		
		public List<ParamCodeModel> getParams()
		{
			return params;
		}
		public boolean isAttach()
		{
			return attachMethod;
		}

		
	}
	