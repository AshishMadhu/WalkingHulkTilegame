package com.test.kannan.tilegame.gfx.images;

import java.awt.image.BufferedImage;

public class TileSpriteSheet {
	
	private BufferedImage tile;
	
	public TileSpriteSheet(BufferedImage tile){
		this.tile = tile;
	}
	public BufferedImage crop(int x, int y, int width, int height){
		return tile.getSubimage(x, y, width, height);
	}

}
