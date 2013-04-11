package com.jhjoeyyoon.hangman;

import com.badlogic.gdx.Input.TextInputListener;

public class MyTextInputListener implements TextInputListener {

	String word;
	@Override
	public void input(String text) {
		word += text;
	}

	@Override
	public void canceled() {
		word = "canceled";
	}

}
