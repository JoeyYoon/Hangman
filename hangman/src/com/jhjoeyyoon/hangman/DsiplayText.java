package com.jhjoeyyoon.hangman;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DsiplayText implements ApplicationListener{
	 
	 SpriteBatch spriteBatch;
	 BitmapFont font;
	 String word;
	 
	 public DsiplayText(String word) {
		 this.word = word;
	 }
	 
	@Override
	public void create() {
		// TODO Auto-generated method stub
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
