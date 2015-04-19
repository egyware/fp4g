package com.apollo.managers;

import com.apollo.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;

public interface CameraController {

	void setRenderManager(RenderManager render);

	void update(float delta);

	void follow(Entity e);

	Camera getCamera();

	void addControlZone(Rectangle rectangle);

	void setCamera(Rectangle rectangle);

}