package com.test.kannan.tilegame.entities.statics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
