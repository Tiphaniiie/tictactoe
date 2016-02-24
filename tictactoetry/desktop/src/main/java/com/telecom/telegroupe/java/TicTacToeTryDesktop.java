package com.telecom.telegroupe.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.telecom.telegroupe.core.TicTacToeTry;

public class TicTacToeTryDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 480;
		config.height= 600;
		new LwjglApplication(new TicTacToeTry(), config);
	}
}
