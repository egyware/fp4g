package com.egysoft.fp4g.net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.MapReferenceResolver;
import com.esotericsoftware.kryonet.KryoSerialization;

public class FP4GSerialization extends KryoSerialization 
{
	public FP4GSerialization () {
		super(new Kryo(new FP4GClassResolver(), new MapReferenceResolver()));
		Kryo kryo = getKryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(true);
	}
}
