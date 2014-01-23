package fp4g.generator.gdx.models;

import java.util.List;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.IValue;
import fp4g.data.define.Asset;
import fp4g.data.expresion.Literal;

public class AssetModel
{	
	public final String type;
	public final String asset;
	public final String parameterClass;
	public final List<String> params;
	
	public AssetModel(Asset define, String resource,List<String> lparams)
	{
		//nombre de la clase a usar
		type = (String)define.get("name").getValue();		
		asset = resource;
		if(lparams.size() > 0)
		{
			IValue<?> value = define.get("parameter");
			if(null == value) Log.Show(ErrType.UnExpectedParams,resource);
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
	
	public final List<String> getParams()
	{
		return params;
	}	
}
