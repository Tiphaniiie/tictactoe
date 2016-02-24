package com.telecom.telegroupe.core;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Image{
	
	TextureRegion tile;
	TextureRegion red;
	TextureRegion circle;
	TextureRegion cross;
	
	TextureRegion player1Won;
	TextureRegion player2Won;
	TextureRegion draw;
	
	HashMap<String, TextureAtlas> atlases;
	
	public Image(){
		atlases	= new HashMap<String, TextureAtlas>();
		loadAtlas("Images/tictactoe.pack", "pack");
		tile 		= getAtlas("pack").findRegion("tile");
		red 		= getAtlas("pack").findRegion("gold");
		circle 		= getAtlas("pack").findRegion("circle");
		cross 		= getAtlas("pack").findRegion("cross");
		player1Won	= getAtlas("pack").findRegion("green");
		player2Won	= getAtlas("pack").findRegion("blue");
		draw		= getAtlas("pack").findRegion("draw");
	}
	
	public void loadAtlas(String path, String key){
		atlases.put(key, new TextureAtlas(Gdx.files.internal(path)));
	}
	
	public TextureAtlas getAtlas(String key){
		return atlases.get(key);
	}

}