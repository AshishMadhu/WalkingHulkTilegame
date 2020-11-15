package com.test.kannan.tilegame.entities.statics;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.gfx.Assets;
import com.test.kannan.tilegame.item.Item;
import com.test.kannan.tilegame.tiles.Tiles;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tiles.TILEWIDTH, Tiles.TILEHEIGHT * 2);
		
		bounds.x = 20;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 35;
		bounds.height = (int) (height - height / 1.5f);       
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x,(int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
