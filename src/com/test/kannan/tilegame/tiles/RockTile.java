package com.test.kannan.tilegame.tiles;

import com.test.kannan.tilegame.gfx.Assets;

public class RockTile extends Tiles {
	
	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	public String toString() {
		return "In Rock Tile";
	}

}
