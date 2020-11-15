package com.test.kannan.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import com.test.kannan.tilegame.gfx.images.DefaultSheet;
import com.test.kannan.tilegame.gfx.images.PlayerImage;
import com.test.kannan.tilegame.gfx.images.SpriteSheet;
import com.test.kannan.tilegame.gfx.images.TileSpriteSheet;
import com.test.kannan.tilegame.gfx.text.FontLoader;

public class Assets {
	private static final int width = 32, height = 32;
	private static final int playerw = 40, playerh = 56;
	
	//Tile and Entity Images
	public static BufferedImage sand, dirt, grass, level2tile, stone, tree, dirt2, rock2, river, grassWithDirt;
	
	//Item images
	public static BufferedImage rockImage, wood;
	
	//Player Image 
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	//UI object
	public static BufferedImage[] btn_start;
	
	//Inventory Screen 
	public static BufferedImage inventoryScreen;
	
	//font
	public static Font font28;
	
	
	public static void init(){
		DefaultSheet defaultSheet = new DefaultSheet(ImageLoader.loadImage("/texture/sheet3.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/sheet.png"));
		TileSpriteSheet tile = new TileSpriteSheet (ImageLoader.loadImage("/texture/sheet2.png"));
		PlayerImage player = new PlayerImage (ImageLoader.loadImage("/texture/player.png"));

		// Font 
		font28 = FontLoader.loadfont("res/fonts/slkscr.ttf", 28);
		
		inventoryScreen = ImageLoader.loadImage("/texture/inventoryScreen.png");
		
		//UI Images
		
		btn_start = new BufferedImage[2];
		
		btn_start[0] = defaultSheet.crop(192, 128, 64, 32);
		btn_start[1] = defaultSheet.crop(192, 160, 64, 32);
		
		//player Image 
		player_down = new BufferedImage [4];
		player_up = new BufferedImage [4];
		player_left= new BufferedImage [4];
		player_right = new BufferedImage [4];
		
		//Storing to player image to array
		
		for (int i = 0; i < 4; i ++){
			player_down[i] = player.crop(playerw *i, 0, playerw, playerh);
			player_left[i] = player.crop(playerw * i, playerh , playerw, playerh);
			player_right[i] = player.crop(playerw * i, playerh * 2, playerw, playerh);
			player_up[i] = player.crop(playerw * i, playerh * 3, playerw, playerh);
		}
		
		//Entity  Images
		wood = defaultSheet.crop(width, height, width, height);
		rockImage = defaultSheet.crop(0, height * 2, width, height);
		river = tile.crop(290, 360, 90, 80);
		tree = tile.crop(960, 0, 60, 160);
		
		//Tiles Image
		grass = sheet.crop(607, 290, 30, 30);
		stone = sheet.crop(320, 130, 29, 30);
		dirt2 = tile.crop(576, 160, width, height);
		rock2 = sheet.crop(672, 224, width, height);
		level2tile = tile.crop(640, 160, width, height);
		grassWithDirt = tile.crop(544, 640, width, height);
		sand = tile.crop(620, 19, width, height);
		dirt = sheet.crop(698, 96, width, height);
	}

}
