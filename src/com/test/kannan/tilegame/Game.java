package com.test.kannan.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.test.kannan.tilegame.display.Display;
import com.test.kannan.tilegame.gfx.Assets;
import com.test.kannan.tilegame.gfx.GameCamera;
import com.test.kannan.tilegame.input.KeyManager;
import com.test.kannan.tilegame.input.MouseManager;
import com.test.kannan.tilegame.states.GameState;
import com.test.kannan.tilegame.states.MenuState;
import com.test.kannan.tilegame.states.State;

public class Game implements Runnable{
	
	private String title;
	private int width, height;
	
	//Thread
	private boolean running = false;
	private Thread thread;
	
	//Drawing Variables
	private Graphics g;
	private BufferStrategy bs;
	
	//Class Objects
	private Display display;
	
	//States
	private State gameState;
	private State menuState;
	
	//Handler
	private Handler handler;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Offset Printing
	private ShowValues showValues;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		handler = new Handler(this);
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		gameCamera = new GameCamera(handler, 0, 0);
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		showValues = new ShowValues(handler);
		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		showValues.tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//Draw here

		if(State.getState() != null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}

	@Override
	public void run(){
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		@SuppressWarnings("unused")
		int ticks = 0;
		
		while(running){
			
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){

				tick();
				render();
				ticks ++;
				delta --;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames:" +ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Getters for input
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
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

	public State getGameState() {
		return gameState;
	}
	
	public State getMenuState() {
		return menuState;
	}
	
}
