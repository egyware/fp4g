package com.egysoft.fp4g.net.serializers;

import java.util.Arrays;
import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


@SuppressWarnings("rawtypes")
public class CollectionSerializer extends Serializer<Collection>
{

	@Override
	public void write(Kryo kryo, Output output, Collection list) 
	{
		output.writeInt(list.size());
		for(Object o:list)
		{
			kryo.writeClassAndObject(output, o);
		}
	}

	@Override
	public Collection read(Kryo kryo, Input input, Class<Collection> type) 
	{
		int size = input.readInt();
		Object array[] = new Object[size];
		for(int i=0;i<size;i++)
		{
			array[i] = kryo.readClassAndObject(input);
		}
		return Arrays.asList(array);
	}

}
