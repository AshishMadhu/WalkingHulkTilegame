package com.test.kannan.tilegame.worlds;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.entities.EntityManager;
import com.test.kannan.tilegame.entities.creatures.Player;
import com.test.kannan.tilegame.entities.statics.Rock;
import com.test.kannan.tilegame.entities.statics.Tree;
import com.test.kannan.tilegame.item.ItemManager;
import com.test.kannan.tilegame.tiles.Tiles;
import com.test.kannan.tilegame.utils.Utils;

public class World {
	
	private int width, height, spawnX, spawnY;
	private int tiles[][];
	private Handler handler;
	
	//For values 
	public int xStart, yStart, xEnd, yEnd;
	
	// Entity Manager
	private EntityManager entityManager;
	
	//Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		entityManager.addEntity(new Tree(handler, 100, 200));
		entityManager.addEntity(new Rock(handler, 100, 400));
		entityManager.addEntity(new Tree(handler, 100, 600));
		entityManager.addEntity(new Rock(handler, 200, 200));
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
			}
		}
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, (handler.getGameCamera().getxOffset() / Tiles.TILEWIDTH));
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tiles.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tiles.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tiles.TILEHEIGHT + 1);
		//for values
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		//
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tiles.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tiles.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}


	public Tiles getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tiles.grassTile;
		Tiles t = Tiles.tiles[tiles[x][y]];
		if(t == null) 
			return Tiles.dirtTile;
		return t;
	}
	
	//Getters and Setters

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}


	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
