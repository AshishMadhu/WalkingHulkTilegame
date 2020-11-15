package com.test.kannan.tilegame.states;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;

public abstract class State {
	protected static State currentState = null;
	protected Handler handler;
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);


}
