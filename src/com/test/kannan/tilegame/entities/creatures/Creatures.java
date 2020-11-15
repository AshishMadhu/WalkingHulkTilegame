package com.test.kannan.tilegame.entities.creatures;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.entities.Entity;
import com.test.kannan.tilegame.tiles.Tiles;

public abstract class Creatures extends Entity {
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CRATEURE_HEIGHT = 64;
	public static final float DEFAULT_SPEED = 3.0f;
	
	public Creatures(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollision(xMove, 0f))
			moveX();
		if(!checkEntityCollision(0f, yMove))
			moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving right
			int tx = (int) ((x + xMove + bounds.x + bounds.width) / Tiles.TILEWIDTH);
			if ( !collisionWithTile(tx, (int) (y + bounds.y) / Tiles.TILEWIDTH) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tiles.TILEHEIGHT)){
//				System.out.println( handler.getWorld().getTile(tx, (int) (y + bounds.y) / Tiles.TILEWIDTH));
//				System.out.println(tx + "\t" +(int) (y + bounds.y) / Tiles.TILEWIDTH);
				x += xMove;
			}else {
				x = tx * Tiles.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}else if(xMove < 0) {
			int tx = (int) ((x + xMove + bounds.x) / Tiles.TILEWIDTH);
			if ( !collisionWithTile(tx, (int) (y + bounds.y) / Tiles.TILEWIDTH) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tiles.TILEHEIGHT)){
//				System.out.println( handler.getWorld().getTile(tx, (int) (y + bounds.y) / Tiles.TILEWIDTH));
//				System.out.println(tx + "\t" +(int) (y + bounds.y) / Tiles.TILEWIDTH);
				x += xMove;
			}else {
				x = tx * Tiles.TILEWIDTH + Tiles.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove > 0) { //Moving down
			int ty = (int) ((y + yMove + bounds.y + bounds.height) / Tiles.TILEHEIGHT);
			if(!collisionWithTile((int) ((x + bounds.x) / Tiles.TILEWIDTH), ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tiles.TILEWIDTH, ty)) {
//				System.out.println(handler.getWorld().getTile((int) ((x + bounds.x) / Tiles.TILEWIDTH), ty));
//				System.out.println((int) ((x + bounds.x) / Tiles.TILEWIDTH) + "\t" + ty);
					y += yMove;
			}else {
				y = ty * Tiles.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}else if(yMove < 0) { // Moving up
			int ty = (int) ((y + yMove + bounds.y) / Tiles.TILEHEIGHT);
			if(!collisionWithTile((int) ((x + bounds.x) / Tiles.TILEWIDTH), ty) && !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tiles.TILEWIDTH), ty)) {
//				System.out.println(handler.getWorld().getTile((int) ((x + bounds.x) / Tiles.TILEWIDTH), ty));
//				System.out.println((int) ((x + bounds.x) / Tiles.TILEWIDTH) + "\t" + ty);
				y += yMove;
			}else {
				y = ty * Tiles.TILEHEIGHT + Tiles.TILEHEIGHT - bounds.y;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

}
