package fp4g.generator.gdx.models.on;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.On;
import fp4g.data.statements.Filter;
import fp4g.data.statements.Source;
import fp4g.exceptions.FP4GException;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;

public class SourceModel
{
	//El codigo
	private List<String> statements;
	//Una lista de filtros (disyunción)
	private List<FiltersD> filters;
	
	public SourceModel(final Source source,final On on,final JavaMetaSourceModel model, final JavaGenerator generator)
	{		
		filters = new LinkedList<FiltersD>();
		if(source.statements != null && source.statements.size() > 0)
		{
			
			try 
			{
				statements = generator.generateStatements(model, on, source.statements);
			} 
			catch (FP4GException e) 
			{
				Log.Exception(e, on.getLine());				
			}			
		}
		else
		{
			statements = null;
		}		
	}
	
	//este no va para el Freemarker
	private FiltersD current;
	private Filter lastFilterIter;
	//devuelve el filtro actual.
	public FiltersD getCurrentFilterD(Filter lf) {
		if(current == null)
		{
			createNewFilterD();
			lastFilterIter = lf;
			return current;
		}
		if(lastFilterIter != lf)
		{
			lastFilterIter = lf;
			createNewFilterD();
		}
		return current;
	}
	
	//guarda y crea otro filtro D
	private void createNewFilterD()
	{			
		current = new FiltersD();	
		filters.add(current);
	}

	public final List<String> getStatements() {
		return statements;
	}
	
	public final List<FiltersD> getFilters() {
		return filters;
	}
}
		
	