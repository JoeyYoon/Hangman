package com.jhjoeyyoon.hangman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.jhjoeyyoon.hangman.Assets;
import com.jhjoeyyoon.hangman.Hangman;

public class PopupScreen implements Screen {	

	Stage stage;
	Hangman game;
	

	
	public PopupScreen(Hangman game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
	
		//dictionary file
		FileHandle file = Gdx.files.internal("dict.txt");
		String temp = file.readString();
		
		
		Window window = new Window("Message", Assets.skin);
		Label label = new Label("Congratulations!", Assets.skin);
		//Label label = new Label(temp, Assets.skin);
		label.setAlignment(Align.center);
		label.setWrap(true);
		window.setPosition((Gdx.graphics.getWidth() - window.getWidth())/2, Gdx.graphics.getHeight()/2);
		window.add(label).width(200);
		window.pack();
		
		TextButton ok = new TextButton("Ok", Assets.skin);
		ok.setPosition(window.getX(), window.getY() - window.getHeight() + ok.getHeight());
		ok.setWidth(window.getWidth()/2);
		ok.addListener(new EventListener(){

			@Override
			public boolean handle(Event event) {
				game.setScreen(game.gameScreen);
				return false;
			}
			
		});
		
		
		TextButton cancel = new TextButton("Cancel", Assets.skin);
		cancel.setPosition(ok.getX() + ok.getWidth(), window.getY() - window.getHeight() + ok.getHeight());
		cancel.setWidth(window.getWidth() - ok.getWidth());
		cancel.addListener(new EventListener() {

			@Override
			public boolean handle(Event event) {
				game.setScreen(game.mainMenu);
				return false;
			}
			
		});
		
		stage.addActor(window);
		stage.addActor(ok);
		stage.addActor(cancel);
		
		
		
	}
	@Override
	public void hide() {
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
