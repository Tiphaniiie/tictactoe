package com.telecom.telegroupe.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Tile {
	
	static final int EMPTY		=-1;
	static final int CIRCLE 	= 0;
	static final int CROSS		= 1;
	
	int player = EMPTY;
	
	float x;
	float y;
	float width;
	float height;
	boolean redFlag = false;
	
	Rectangle rectangle	= new Rectangle();
	Image image = new Image();
	
	public Tile(float x, float y, float width, float height){
		this.x=x;
		this.y=y;
		this.width=width-4;//4 is tile spacing
		this.height=height-4;		
	}
	
	public int getPlayer(){
		return player;
	}
	
	public void render(SpriteBatch batch){
		batch.draw(image.tile,x-width/2,y-height/2, width, height);
		if(redFlag){
			batch.draw(image.red,x-width/2,y-height/2, width, height);
		}
		if(player==CIRCLE){
			batch.draw(image.circle,x-width/2,y-height/2, width, height);
		}else if(player==CROSS){
			batch.draw(image.cross,x-width/2,y-height/2, width, height);
		}
	}
	
	public boolean touched(float x, float y){
		rectangle.set(this.x-width/2, this.y-height/2,width,height);
		return rectangle.contains(x, y);
		
	}

}