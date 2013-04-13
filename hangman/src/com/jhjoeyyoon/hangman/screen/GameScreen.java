package com.jhjoeyyoon.hangman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.jhjoeyyoon.hangman.Hangman;
import com.jhjoeyyoon.hangman.Assets;
import com.jhjoeyyoon.hangman.MyTextInputListener;

public class GameScreen implements Screen {

	Hangman game;	
	Stage stage;
	TextButton back;
	
	//TextInput
	TextButton key;
	TextField textfield;
	MyTextInputListener listener;
	SpriteBatch batch;
	BitmapFont font;
	
	public GameScreen(Hangman game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		batch = new SpriteBatch();
		font = new BitmapFont();
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		
		//check the answer
		if(textfield.getText().equalsIgnoreCase("AAA")) {
			textfield.getOnscreenKeyboard().show(false);
			game.setScreen(new PopupScreen(game));
		}
		
//		batch.begin();
//compare the result
//		font.draw(batch, text, 0, 0);
//		if(textfield.getText().equalsIgnoreCase("a")) {
//			font.draw(batch, "Congrats", 10, 40);
//		} else {
//			//font.draw(batch, textfield.getText(), 10, 40);
//			font.draw(batch, text, 10, 40);
//		}
//		batch.end();
		
		
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
	textfield = new TextField("Enter Text", Assets.skin);	
	//textfield.setOriginX(200);
	textfield.setX((backImage.getWidth() - textfield.getWidth())/2);
	textfield.setY(backImage.getTop()/2);
	textfield.setTextFieldListener(new TextFieldListener() {

		@Override
		public void keyTyped(TextField textField, char key) {
			// TODO Auto-generated method stub
			if(key == '\n')
				textField.getOnscreenKeyboard().show(false);
			
			//if (textField.getMessageText().equalsIgnoreCase("A")) {
			//	game.setScreen(game.mainMenu);
			//}
		}	
	});
	
/*	Read a file from a dictionary
	FileHandle file = Assets.handle;
	String text = file.readString();

	if(text.equalsIgnoreCase("AA")) {
		game.setScreen(new PopupScreen(game));
	}*/
	

	
	/*	key = new TextButton("Enter Text", Assets.skin);
		//key.center();
		key.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				listener = new MyTextInputListener();
				//Gdx.input.setOnscreenKeyboardVisible(true);
				Gdx.input.getTextInput((TextInputListener) listener, "Guess the solution", "");
				return false;
			}
		});
	*/	
		//visible keyboard
//		if(Gdx.input.isTouched()) {
//			Gdx.input.setOnscreenKeyboardVisible(true);
//		}
		
		
		stage.addActor(backImage);
		stage.addActor(back);
//		stage.addActor(key);
		stage.addActor(textfield);
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
	

	public boolean needsGL20() {
		return false;
	}
	
	
}
