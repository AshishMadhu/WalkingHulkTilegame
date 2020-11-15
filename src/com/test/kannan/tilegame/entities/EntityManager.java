package com.test.kannan.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.entities.creatures.Player;

public class EntityManager {
	private Player player;
	
	@SuppressWarnings("unused")
	private Handler handler;
	
	// ArrayList for storing Entities
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}};
	
	public EntityManager(Handler handler, Player player) {
		this.player = player;
		this.handler = handler;
		entities = new ArrayList<Entity>();
		addEntity(player);
		handler.setPlayer(player);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
		player.postRender(g);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	// Getters and Setters 
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
