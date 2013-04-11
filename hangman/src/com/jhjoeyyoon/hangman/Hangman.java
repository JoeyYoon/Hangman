package com.jhjoeyyoon.hangman;

import com.badlogic.gdx.Game;
import com.jhjoeyyoon.hangman.screen.GameScreen;
import com.jhjoeyyoon.hangman.screen.MainMenu;


public class Hangman extends Game {
	
	public MainMenu mainMenu;
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		Assets.load();
		mainMenu = new MainMenu(this);
		gameScreen = new GameScreen(this);
		// TODO Auto-generated method stub
		setScreen(mainMenu);
	}
}
