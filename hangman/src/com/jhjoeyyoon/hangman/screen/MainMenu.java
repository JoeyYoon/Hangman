package com.jhjoeyyoon.hangman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jhjoeyyoon.hangman.Assets;
import com.jhjoeyyoon.hangman.Hangman;

public class MainMenu implements Screen {

	private Skin skin;
	Hangman game;
	Stage stage;
	TextButton startGameButton;

	//Button optionsButton;
	//TextButton exitButton;
	
	public MainMenu(Hangman game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
//		Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		stage = new Stage();
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		Table table = new Table(Assets.skin);
		
		startGameButton = new TextButton("New Game", skin);
		startGameButton.setX(Gdx.graphics.getWidth()/2);
		startGameButton.setY(Gdx.graphics.getHeight()/2);
		startGameButton.setPosition(0, 0);

		Gdx.input.setInputProcessor(stage);
		//optionsButton = new TextButton("Options", skin);
		//exitButton = new TextButton("Exit", Assets.skin);
		Image backImage = new Image(Assets.backgroundTexture);
		//backImage.setX(Gdx.graphics.getWidth());
		//backImage.setY(Gdx.graphics.getHeight());
		//backImage.setPosition(0, 0);
		
		startGameButton.addListener(new EventListener() {

			@Override
			public boolean handle(Event event) {
				game.setScreen(game.gameScreen);
				return true;
			}
		});
	    
		/*
		startGameButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				game.setScreen(new GameScreen(game));				
				return true;
			}
		});*/
		/*
		optionsButton.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				game.setScreen(new optionScreen(game));
				
				return true;
			}
			
		});
		*/
		table.setFillParent(true);
		table.bottom();
//		table.debug(); 
		table.add(startGameButton).width(150).height(50);
		//table.row();
		//table.add(optionsButton).width(150).height(50).padTop(10);
		//table.row();
		//table.add(exitButton).width(150).height(50).padTop(10);	
		backImage.setFillParent(true);
		stage.addActor(backImage);
		stage.addActor(startGameButton);
		//stage.addActor(table);
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
