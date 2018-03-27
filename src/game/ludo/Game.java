package game.ludo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	private final Board board;
	private final Player[] players;
	
	
	private Game(GameBuilder builder) {
		// TODO Auto-generated constructor stub
		this.board = builder.board;
		this.players =  builder.player;
	}
	
	public static int diceThrow(){		
		return (int)(Math.random()*6+1);	
	}
	
	
	public void playerMove(int playerIndex) throws NumberFormatException, IOException{		
		int diceResult = diceThrow();
		// Ask player to choose a token
		System.out.println("Dice throw result: "+diceResult);		
		
		// select token to move
		// Ask player which token to move		
		Token[] selectedPostion = board.selectPlayerToken(0,players[playerIndex]);		
		// check if he can play a move	
		if(!checkPlayerValidMove(this.players[playerIndex],diceResult,board)){
			return;
		}
		System.out.println("Select token to move from board");		
	}
	
	public void getPlayerMoveOption(){
		
	}
	public boolean checkPlayerValidMove(Player player,int diceThrow,Board board){
		return true;
	}	
	
	public static class GameBuilder{
		private Board board;
		private Player[] player;
		
		public GameBuilder setBoard(Board board) {
			this.board = board;
			return this;
		}
		public GameBuilder createPlayers(int playerCount,String[] names){
			if(names.length != playerCount) throw new IllegalArgumentException("Provide "+playerCount+" names");
			for(int i = 0; i< playerCount; i++){
				this.player[i] = new Player(names[i],TokenColour.values()[i]);
			}
			return this;
		}
		
		public Game build(){
			return new Game(this);
		}
		
	}
}
