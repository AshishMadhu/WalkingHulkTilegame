package com.test.kannan.tilegame.item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.test.kannan.tilegame.Handler;

public class ItemManager {
	private Handler handler;
	private ArrayList<Item> items;
	
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPicked_up())
				it.remove();
		}
		
	}
	
	public void render(Graphics g) {
		for(Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}
}
