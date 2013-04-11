package com.jhjoeyyoon.hangman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jhjoeyyoon.hangman.Hangman;
import com.jhjoeyyoon.hangman.Assets;
import com.jhjoeyyoon.hangman.MyTextInputListener;

public class GameScreen implements Screen {

	Hangman game;	
	Stage stage;
	TextButton back;
	
	
	
	public GameScreen(Hangman game) {
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
		// TODO Auto-generated method stub
		stage = new Stage();
		
		Image backImage = new Image(Assets.anotherBackground);
		backImage.setHeight(Gdx.graphics.getHeight());
		backImage.setWidth(Gdx.graphics.getWidth());
		Gdx.input.setInputProcessor(stage);
		
		//create buttons
		back = new TextButton("Back", Assets.skin);
		back.setX(0);
		back.setY(backImage.getTop()-back.getHeight());
		back.addListener(new EventListener() {

			@Override
			public boolean handle(Event event) {
				game.setScreen(game.mainMenu);
				//game.setScreen(MainMenuScreen);
				return true;
			}
			
		});
	
	//for keyboard	
		TextButton key = new TextButton("Enter Text", Assets.skin);
		key.center();
		key.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				MyTextInputListener listener = new MyTextInputListener();
				Gdx.input.getTextInput((TextInputListener) listener, "Guess the solution", "");
				return true;
			}
			
		});
		//visible keyboard
//		if(Gdx.input.isTouched()) {
//			Gdx.input.setOnscreenKeyboardVisible(true);
//		}
		
		stage.addActor(backImage);
		stage.addActor(back);
		stage.addActor(key);
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
