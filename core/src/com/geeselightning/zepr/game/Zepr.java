package com.geeselightning.zepr.game;

import com.badlogic.gdx.Game;
import com.geeselightning.zepr.levels.CourtyardLevel;
import com.geeselightning.zepr.levels.HalifaxLevel;
import com.geeselightning.zepr.levels.Level;
import com.geeselightning.zepr.levels.TownLevel;
import com.geeselightning.zepr.screens.MenuScreen;
import com.geeselightning.zepr.screens.SelectLevelScreen;
import com.geeselightning.zepr.screens.LoadingScreen;

public class Zepr extends Game {

	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;
	private Level level;
	private SelectLevelScreen selectLevelScreen;

	// The progress is the integer representing the last level completed. i.e. 3 for Town
	public int progress = 3;
	
	public static boolean devMode;

	public final static int MENU = 0;
	public final static int SELECT = 2;
	public final static int TOWN = 3;
	public final static int HALIFAX = 4;
	public final static int COURTYARD = 5;
	public final static int COMPLETE = 6;
	
	public Zepr(boolean devMode) {
		super();
		Zepr.devMode = devMode;
	}


	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if (menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case SELECT:
				selectLevelScreen = new SelectLevelScreen(this);
				this.setScreen(selectLevelScreen);
				break;
			case TOWN:
				level = new TownLevel(this);
				this.setScreen(level);
				break;
			case HALIFAX:
				level = new HalifaxLevel(this);
				this.setScreen(level);
				break;
			case COURTYARD:
				level = new CourtyardLevel(this);
				this.setScreen(level);
				break;
		}
	}

	@Override
	public void create() {
		changeScreen(MENU);
	}
}