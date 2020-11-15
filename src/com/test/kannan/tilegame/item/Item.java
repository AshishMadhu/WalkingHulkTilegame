package com.test.kannan.tilegame.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.gfx.Assets;

public class Item {
	
	public static Item[] items = new Item[256];
	public static Item woodItem = new Item(Assets.wood, "Wood", 0);
	public static Item rockItem = new Item(Assets.rockImage, "Rock", 1);
	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected Handler handler;
	protected String name;
	protected int x, y , count;
	protected final int id;
	protected BufferedImage texture;
	protected Rectangle bounds;
	protected boolean picked_up = false;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		
		count = 1;
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		items[id] = this;
	}
	
	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			picked_up = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}

	public void render(Graphics g) {
		if(handler == null)
			return;
		g.drawImage(texture, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), ITEMWIDTH, ITEMHEIGHT, null);

//		g.setColor(Color.RED);
//		g.fillRect(bounds.x, bounds.y, ITEMWIDTH, ITEMHEIGHT);
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	//development purpose
	public Item createNew(int count) {
		Item i = new Item(texture, name, id);
		i.setPicked_up(true);
		i.setCount(count);
		return i;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	//Getters and Setters

	
	public BufferedImage getTexture() {
		return texture;
	}

	public boolean isPicked_up() {
		return picked_up;
	}
	
	public void setPicked_up(boolean picked_up) {
		this.picked_up = picked_up;
	}

	public String getNamae() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public Handler getHandler() {
		return handler;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

}
