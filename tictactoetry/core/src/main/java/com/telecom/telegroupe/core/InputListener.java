package com.telecom.telegroupe.core;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

public class InputListener extends InputAdapter{
	TicTacToeTry ticTacToe;
	Vector3 coordinate = new Vector3();

	public InputListener(TicTacToeTry ticTacToe){
		this.ticTacToe=ticTacToe;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button){
		coordinate.set(screenX, screenY, 0);
		ticTacToe.camera.unproject(coordinate);

		if(ticTacToe.gameState==0){
			for(int row=0;row<ticTacToe.tiles.length;row++){
				for(int col=0;col<ticTacToe.tiles[0].length;col++){
					Tile tile = ticTacToe.tiles[row][col];

					if(tile.touched(coordinate.x, coordinate.y)){
						if(tile.player==Tile.EMPTY){
							tile.player = ticTacToe.playerTurn?Tile.CROSS:Tile.CIRCLE;								
							ticTacToe.playerTurn = !ticTacToe.playerTurn;
							ticTacToe.checkGameState();
						}else{
							tile.player = Tile.CROSS;
							ticTacToe.checkGameState();

						}
						break;
					}
				}
			}
		}
		return super.touchDown(screenX, screenY, pointer, button);
	}
}