package com.test.kannan.tilegame;


public class ShowValues {
	private Handler handler;
	
	public ShowValues(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		if(handler.getKeyManager().oKey && handler.getKeyManager().cKey)
			System.out.println("Camera Xoffset is\t " + handler.getGameCamera().getxOffset() + "\tYoffset is\t" + handler.getGameCamera().getyOffset());
		if(handler.getKeyManager().oKey && handler.getKeyManager().pKey)
			System.out.println("Player Xoffset is\t " + (handler.getPlayer().getxOffset() + "\tYoffset is\t") + handler.getPlayer().getyOffset());
		if(handler.getKeyManager().oKey && handler.getKeyManager().wKey)
			System.out.println("World XStart is " + (handler.getWorld().xStart + "\tYStart is ") + handler.getWorld().yStart + "\tXEnd is " + handler.getWorld().xEnd + "\tYEnd is " + handler.getWorld().yEnd);
	}

}
