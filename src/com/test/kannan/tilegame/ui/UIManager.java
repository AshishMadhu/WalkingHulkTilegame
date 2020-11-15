package com.test.kannan.tilegame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.test.kannan.tilegame.Handler;

public class UIManager {
	private Handler handler;
	private ArrayList<UIObjects> objects;
	
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObjects>();
	}
	
	public void tick() {
		for(UIObjects o : objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(UIObjects o : objects) {
			o.render(g);
		}
	}
	
	public void addObjects(UIObjects o) {
		objects.add(o);
	}
	
	public void removeObject(UIObjects o) {
		objects.remove(o);
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UIObjects o : objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(UIObjects o : objects) {
			o.onMouseRelease(e);
		}
	}

}
