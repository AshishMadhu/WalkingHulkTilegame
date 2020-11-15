package com.test.kannan.tilegame.gfx.images;

import java.awt.image.BufferedImage;

public class DefaultSheet {
	
	private BufferedImage defaultSheet;
	
	public DefaultSheet(BufferedImage defaultSheet) {
		this.defaultSheet = defaultSheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return defaultSheet.getSubimage(x, y, width, height);
	}

}
