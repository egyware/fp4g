package com.apollo.managers.graphics;

import java.util.regex.Pattern;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedMap;

public class Sprite {
	public static final int DEFAULT_DURATION = 200; //100 ms
	private OrderedMap<String,Animation> animations;
	
	private Sprite()
	{
		animations = new OrderedMap<String,Animation>();
	}
	
	public static Sprite build(FileHandle resolve, TextureAtlas atlas) {
		String txt = resolve.readString();
		String animations[] = txt.split("[\n\r]+");
		Pattern regex = Pattern.compile(",");
		Sprite animation = new Sprite();
		for(String ani: animations)
		{		
			
			AtlasRegion array[] = null;
			int size = 0,duration = DEFAULT_DURATION;
			String data[] = regex.split(ani,4);
			String name = data[0];
			Array<AtlasRegion> regions = atlas.findRegions(name);						
			size = Integer.parseInt(data[1]);
			//opcionales...
			if(data.length >= 3)
			{
				if(data[2].length()>0)
				{
					duration = Integer.parseInt(data[2]);
				}
			    if(data.length == 4)
			    {	
			    	String sarray[] = regex.split(data[3].substring(1,data[3].length()-1));
			    	final int lenght = sarray.length;
			    	array = new AtlasRegion[lenght];
			    	for(int i=0;i<lenght;i++)
			    	{
			    		array[i] = regions.get(Integer.parseInt(sarray[i])-1); //1 based index to 0 based index
			    	}
			    }
			}			
			if(array == null)
			{
				array = new AtlasRegion[size];
				for(int i=0;i<size;i++)
				{
					array[i] = regions.get(i);
				}
			}
			//ya ahora están listos los datos :D
			animation.animations.put(name, new Animation(duration*0.001f,array));
			
		}		
		return animation;
	}
	
	public Animation getFirstAnimation() {
		return animations.values().next();		
	}
	public void addAnimation(String id, Animation s) {
		animations.put(id, s);
		s.setPlayMode(Animation.LOOP);
	}

	public Animation getAnimation(String id) {
		return animations.get(id);		
	}

	public TextureRegion getKeyFrame(Animation current_sequence,float current_time,boolean loop) {		
		return current_sequence.getKeyFrame(current_time,loop);
	}




}
