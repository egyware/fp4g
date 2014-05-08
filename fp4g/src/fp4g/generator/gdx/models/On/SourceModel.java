package fp4g.generator.gdx.models.On;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.On;
import fp4g.data.statements.Filter;
import fp4g.data.statements.Source;
import fp4g.generator.StatementModel;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class SourceModel
{
	//El codigo
	private final List<StatementModel> statements;
	//Una lista de filtros (disyunción)
	private final List<FiltersD> filters;
	
	public SourceModel(final Source source,final On on,final JavaMetaSourceModel model, final JavaGenerator generator)
	{		
		filters = new LinkedList<FiltersD>();
		if(source.statements != null && source.statements.size() > 0)
		{
			
			statements = generator.generateStatements(model, on, source.statements);
			
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

	public final List<StatementModel> getStatements() {
		return statements;
	}
	
	public final List<FiltersD> getFilters() {
		return filters;
	}
}
		
	