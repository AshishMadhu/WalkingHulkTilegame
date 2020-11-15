package com.test.kannan.tilegame;

import com.test.kannan.tilegame.entities.creatures.Player;
import com.test.kannan.tilegame.gfx.GameCamera;
import com.test.kannan.tilegame.input.KeyManager;
import com.test.kannan.tilegame.input.MouseManager;
import com.test.kannan.tilegame.states.State;
import com.test.kannan.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private Player player;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public State getGameState() {
		return game.getGameState();
	}
	public State getMenuState() {
		return game.getMenuState();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public World getWorld() {
		return world;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
