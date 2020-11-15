package com.test.kannan.tilegame.states;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.worlds.World;

public class GameState extends State {
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new   World(handler, "res/worlds/World1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
}
