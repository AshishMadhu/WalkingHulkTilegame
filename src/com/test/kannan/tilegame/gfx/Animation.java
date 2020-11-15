package com.test.kannan.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index;
	private BufferedImage[] frames;
	private long lastTime, timer;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		lastTime = System.currentTimeMillis();
		index = 0;
		timer = 0;
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index ++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
	}
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}
