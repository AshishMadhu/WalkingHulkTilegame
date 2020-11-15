package com.test.kannan.tilegame.entities.statics;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.gfx.Assets;
import com.test.kannan.tilegame.item.Item;
import com.test.kannan.tilegame.tiles.Tiles;

public class Rock extends StaticEntity{

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tiles.TILEWIDTH, Tiles.TILEHEIGHT);
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x,(int) y));
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rockImage, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
