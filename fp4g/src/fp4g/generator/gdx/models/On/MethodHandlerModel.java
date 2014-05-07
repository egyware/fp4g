package fp4g.generator.gdx.models.On;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.AddMethod;
import fp4g.generator.gdx.models.VarCodeModel;

public final class MethodHandlerModel
	{
		//que necesito acá, por cada MethodHander necesito:
		//Nombre del metodo
		private final String name;		
		//Una lista de Source Codes
		private final List<SourceModel> sources;
		//Parametros
		private final List<VarCodeModel> params;
		//Se requiere attach?
		private final boolean attachMethod;
				
		public MethodHandlerModel(AddMethod method, List<VarCodeModel> p)
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
		
		public List<VarCodeModel> getParams()
		{
			return params;
		}
		public boolean isAttach()
		{
			return attachMethod;
		}

		
	}
	