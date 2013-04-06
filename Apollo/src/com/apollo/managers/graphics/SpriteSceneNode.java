package com.apollo.managers.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSceneNode extends SceneNode{
	private TextureRegion region[];
	private TextureRegion current_region;
	private int frame_index;
	
	public SpriteSceneNode(TextureRegion _region[]){
		region = _region;
		current_region = region[0];
	}
	
	public void setFrameIndex(int index) {
		frame_index = (index  < region.length)?index:region.length-1;
		current_region = region[index];
	}
	
	public int getFrameIndex()
	{
		return frame_index;
	}

	@Override
	public void draw(SpriteBatch batch, float dt) {		
		batch.draw(current_region, position.x, position.y);
	}
	

}
