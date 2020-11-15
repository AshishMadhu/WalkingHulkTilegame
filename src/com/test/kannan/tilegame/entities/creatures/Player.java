package com.test.kannan.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.entities.Entity;
import com.test.kannan.tilegame.gfx.Animation;
import com.test.kannan.tilegame.gfx.Assets;
import com.test.kannan.tilegame.inventory.Inventory;

public class Player extends Creatures {
	//for values
	private float xOffset, yOffset;
	//
	// Animation
	private Animation animDown, animUp, animLeft, animRight;
	
	// To store the direction of player facing
	private String f = "DOWN";
	// For Attacking
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	//Inventory
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CRATEURE_HEIGHT);
		bounds.x = 20;
		bounds.y = 26;
		bounds.width = 23;
		bounds.height = 35;
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animRight = new Animation(200, Assets.player_right);
		animLeft = new Animation(200, Assets.player_left);
		
		inventory = new Inventory(handler);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		checkAttack();
		
		inventory.tick();
	}
	
	@Override
	public void die() {
		System.out.println("You lose!");
	}
	
	public void checkAttack() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0f, 0f);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(f == "UP" && handler.getKeyManager().gKey) {
			ar.x = cb.x + cb.width / 2 - ar.width / 2;
			ar.y = cb.y - arSize;
		}else if(f == "DOWN" && handler.getKeyManager().gKey) {
			ar.x = cb.x + cb.width / 2 - ar.width;
			ar.y = cb.y + cb.height;			
		}else if(f == "RIGHT" && handler.getKeyManager().gKey) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 + ar.height / 2;			
		}else if(f == "LEFT" && handler.getKeyManager().gKey) {
			ar.x = cb.x - ar.width;
			ar.y = cb.y + cb.height / 2 + ar.height / 2;		
		}else
			return;
		
		attackTimer = 0;
		
		//Checking whether the Collision box intersects with the attacking bounds
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up || handler.getKeyManager().upr) yMove = -speed;
		if(handler.getKeyManager().down || handler.getKeyManager().downr) yMove = speed;
		if(handler.getKeyManager().left || handler.getKeyManager().leftr) xMove = -speed;
		if(handler.getKeyManager().right || handler.getKeyManager().rightr) xMove = speed;
		
	}

	@Override
	public void render(Graphics g) {
		//for values
		xOffset = x - handler.getGameCamera().getxOffset();
		yOffset = y - handler.getGameCamera().getyOffset();
		//
		g.drawImage(getCurrentAnimationFrame(), (int) (xOffset), (int) (yOffset), width, height, null);
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if(xMove > 0) {
			f = "RIGHT";
			return animRight.getCurrentFrame();
		}else if(xMove < 0) {
			f = "LEFT";
			return animLeft.getCurrentFrame();
		}else if(yMove > 0) {
			f = "DOWN";
			return animDown.getCurrentFrame();
		}else if(yMove < 0) {
			f = "UP";
			return animUp.getCurrentFrame();
		}else if(f == "RIGHT"){
			return Assets.player_right[0];
		}else if(f == "LEFT") {
			return Assets.player_left[0];
		}else if(f == "UP") {
			return Assets.player_up[0];
		}else
			return Assets.player_down[0];
	}
	
	//Getters for values
	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}
	//

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
