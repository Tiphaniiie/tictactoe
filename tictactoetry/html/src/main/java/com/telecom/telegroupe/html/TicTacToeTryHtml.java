package com.telecom.telegroupe.html;

import com.telecom.telegroupe.core.TicTacToeTry;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class TicTacToeTryHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new TicTacToeTry();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
