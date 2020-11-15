package com.test.kannan.tilegame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class UIButtionImage extends UIObjects{
	
	private BufferedImage[] texture;
	private ClickListener clicker;
	public static final int DEFAULT_WIDTH = 128, DEFAULT_HEIGHT = 64;


	public UIButtionImage(float x, float y, BufferedImage[] texture, ClickListener clicker) {
		super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.texture = texture;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(texture[0], (int) x, (int) y, width, height, null);
		else
			g.drawImage(texture[1], (int) x, (int) y, width, height, null);
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
