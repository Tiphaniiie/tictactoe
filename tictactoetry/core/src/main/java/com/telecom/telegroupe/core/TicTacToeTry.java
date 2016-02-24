package com.telecom.telegroupe.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TicTacToeTry extends ApplicationAdapter{

	SpriteBatch batch;
	OrthographicCamera camera;

	final int WIDTH = 480;
	final int HEIGHT= 600;

	int tileSize;
	int boardOffset;
	int boardHeight;

	Tile[][] tiles;
	Image image;

	int player;

	boolean playerTurn 	= true;
	boolean gameType 	= true;
	int gameState		= 0;

	int playing			= 0;
	int playerXWon		= 1;
	int playerOWon 		= 2;
	int draw			= 3;	

	@Override
	public void create () {
		tiles = new Tile[3][3];
		image = new Image();

		tileSize = WIDTH/tiles[0].length;
		boardOffset =  (HEIGHT-tileSize*tiles.length)/2;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		batch = new SpriteBatch();

		for(int row=0;row<tiles.length;row++){
			for(int col=0;col<tiles[0].length;col++){
				tiles[row][col] = new Tile(col*tileSize+tileSize/2,
						row*tileSize+boardOffset+tileSize/2,
						tileSize,
						tileSize);
			}
		}
		Gdx.input.setInputProcessor(new InputListener(this));
	}

	public boolean checkWinner(int winner, Tile[][] tiles){
		//check rows
		for(int row = 0; row<tiles.length;row++){
			if(tiles[row][0].getPlayer()==winner && 
					tiles[row][1].getPlayer()==winner && 
					tiles[row][2].getPlayer()==winner){
				tiles[row][0].redFlag = true;
				tiles[row][1].redFlag = true;
				tiles[row][2].redFlag = true;
				return true;
			}
			
		}

		//check columns
		for(int col = 0;col<tiles.length;col++){
			if(tiles[0][col].getPlayer()==winner && 
					tiles[1][col].getPlayer()==winner && 
					tiles[2][col].getPlayer()==winner){
				tiles[0][col].redFlag = true;
				tiles[1][col].redFlag = true;
				tiles[2][col].redFlag = true;
				return true;
			}
		}

		//check diagonal 1
		if(tiles[0][0].getPlayer()==winner&&
				tiles[1][1].getPlayer()==winner&&
				tiles[2][2].getPlayer()==winner){
			tiles[0][0].redFlag = true;
			tiles[1][1].redFlag = true;
			tiles[2][2].redFlag = true;
			return true;
		}

		//check diagonal 2
		if(tiles[0][2].getPlayer()==winner&&
				tiles[1][1].getPlayer()==winner&&
				tiles[2][0].getPlayer()==winner){
			tiles[0][2].redFlag = true;
			tiles[1][1].redFlag = true;
			tiles[2][0].redFlag = true;
			return true;
		}
		return false;
	}
	
	public int getGameState(Tile[][] tiles){

		if(checkWinner(Tile.CROSS,tiles)){
			return playerXWon; 
		}
		
		if(checkWinner(Tile.CIRCLE,tiles)){
			return playerOWon;
		}

		for(int row=0;row<tiles.length;row++){
			for(int col=0;col<tiles.length;col++){
				if(tiles[row][col].player==Tile.EMPTY){
					return playing;
				}
			}
		}		
		return draw;
	}

	public void checkGameState(){
		int state = getGameState(tiles);
		if(state==1)
			gameState = playerXWon;
		if(state==2)
			gameState = playerOWon;			
		if(state==3)
			gameState = draw;

	}

	public void update(float dt){

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[0].length; col++) {
				tiles[row][col].render(batch);
			}
		}

		if(gameState==playerXWon){
			batch.draw(image.player1Won,240-108/2f,290,208,27);
		}

		if(gameState==playerOWon){
			batch.draw(image.player2Won,240-108/2f,290,208,27);
		}
		if(gameState==draw){
			batch.draw(image.draw,240-108/2f,290,208,27);
		}


		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}