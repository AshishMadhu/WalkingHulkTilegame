package com.test.kannan.tilegame.gfx.images;

import java.awt.image.BufferedImage;

public class PlayerImage {
	private BufferedImage player;
	
	public PlayerImage(BufferedImage player){
		this.player = player;
	}
	public BufferedImage crop(int x, int y, int width, int height){
		return player.getSubimage(x,  y, width, height);
	}

}
