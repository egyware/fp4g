package fp4g.generator.gdx.models;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.core.IValue;
import fp4g.data.define.Asset;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

public class AssetModel
{	
	public final String type;
	public final String asset;
	public final String parameterClass;
	public final Map<String,String> params;
	
	public AssetModel(Asset define, String resource, Map<String,String> lparams)
	{
		//nombre de la clase a usar
		IValue<?> className = define.get("className");
		type = (className != null)?(String)className.getValue():define.name;		
		asset = resource;
		if(lparams.size() > 0)
		{
			IValue<?> value = define.get("classParameter");
			if(null == value) new FP4GRuntimeException(FP4GError.UnExpectedParams,"Faltan parametros");
			parameterClass = (String)value.getValue();
			params = lparams;
		}
		else
		{
			parameterClass = null;
			params = null;
		}
	}
	
	
	public final String getType()
	{
		return type;
	}
	public final String getAsset()
	{
		return asset;
	}
	public final String getResource()
	{
		return asset;
	}
	public final String getParameterName()
	{
		return parameterClass;
	}
	
	public final Set<Entry<String,String>> getParams()
	{
		return params.entrySet();
	}	
}
