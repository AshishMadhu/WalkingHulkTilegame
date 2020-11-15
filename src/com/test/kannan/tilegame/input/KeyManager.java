package com.test.kannan.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener{
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, upr, downr, leftr, rightr, oKey,
					cKey, pKey, wKey, gKey;
	
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick() {
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			}else if(justPressed[i]) {
				justPressed[i] = false;
				cantPress[i] = true;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		if(keyJustPressed(KeyEvent.VK_E)) {
			System.out.println("E just Pressed");
		}
		up = keys[KeyEvent.VK_W];
		upr = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S];
		downr = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A];
		leftr = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D];
		rightr = keys[KeyEvent.VK_RIGHT];
		oKey = keys[KeyEvent.VK_O];
		cKey = keys[KeyEvent.VK_C];
		pKey = keys[KeyEvent.VK_P];
		wKey = keys[KeyEvent.VK_W];
		gKey = keys[KeyEvent.VK_G];
	}
	
	public boolean keyJustPressed(int e) {
		if(e < 0 || e >= keys.length)
			return false;
		return justPressed[e];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length)
			return;
		
		keys[e.getKeyCode()] = true;	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length)
			return;
		
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
