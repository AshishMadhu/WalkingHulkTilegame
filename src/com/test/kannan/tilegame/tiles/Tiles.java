package com.test.kannan.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tiles {
	
	protected BufferedImage texture;
	protected final int id;
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	public static Tiles[] tiles = new Tiles[256];
	
	//It is important that we need to set all the tiles as static 
	public static Tiles grassTile = new GrassTile(0);
	public static Tiles dirtTile = new DirtTile(1);
	public static Tiles rockTile = new RockTile(2);
	public static Tiles dirtTile2 = new DirtTile2(3);
	
	public Tiles(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

}
