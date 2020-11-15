package com.test.kannan.tilegame.states;

import java.awt.Graphics;

import com.test.kannan.tilegame.Handler;
import com.test.kannan.tilegame.gfx.Assets;
import com.test.kannan.tilegame.ui.ClickListener;
import com.test.kannan.tilegame.ui.UIButtionImage;
import com.test.kannan.tilegame.ui.UIManager;

public class MenuState extends State {
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		uiManager.addObjects(new UIButtionImage(handler.getWidth() / 2 - 64, handler.getHeight() / 2  - 32, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				State.setState(handler.getGameState());
				
			}} ));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
		
//		// For development purpose
//		handler.getMouseManager().setUiManager(null);
//		State.setState(handler.getGameState());
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
