package com.jhjoeyyoon.hangman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
	public static Texture backgroundTexture,anotherBackground;
	public static Skin skin;
	
	public static void load () {
		Texture.setEnforcePotImages(false); //preventing power of 2 error for an image file

		backgroundTexture = new Texture(Gdx.files.internal("back.jpg"));
		anotherBackground = new Texture(Gdx.files.internal("anotherback.jpg"));
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		
	}

}
