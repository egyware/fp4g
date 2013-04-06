/**
 * 
 */
package com.apollo.managers.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author egyware
 *
 */
public class BackgroundSceneNode extends SceneNode {
	private TextureRegion region = new TextureRegion();
	
	public TextureRegion Region()
	{
		return region;
	}
	
	/* (non-Javadoc)
	 * @see com.teamnayn.empujame.graphics.SceneNode#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
	@Override
	public void draw(SpriteBatch batch, float dt) {
		batch.draw(region, position.x, position.y);
	}

}
