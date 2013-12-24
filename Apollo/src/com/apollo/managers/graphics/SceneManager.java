package com.apollo.managers.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * @author egyware
 *
 */
public final class SceneManager 
{
	private Camera camera;
	private SnapshotArray<SceneNode> nodes = new SnapshotArray<SceneNode>();
	private SpriteBatch batch = new SpriteBatch();
	
	public SceneManager()
	{		
	}
	
	public void update(float dt)
	{	
		camera.update();
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		Object array[] = nodes.begin(); ///\TODO hay un error conocido..., que error conocido?
		
		for(int i = 0; i < array.length; i ++)
		{
			if(array[i] != null)
			{
				((SceneNode)array[i]).draw(batch, dt);
			}
		}
		nodes.end();
		batch.end();		
	}
	
	public void addSceneNode(SceneNode node)
	{
		nodes.add(node);
	}
	
	public void removeSceneNode(SceneNode node)
	{
		nodes.removeValue(node, true);
	}

	public void setCamara(Camera _camera) {
		camera = _camera;		
	}	
}
