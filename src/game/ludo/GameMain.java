/**
 * 
 */
package game.ludo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sumant.dey
 *
 */
public class GameMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NumberFormatException,IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of Players?");
		int playerCount = Integer.parseInt(br.readLine());
		String[] names = new String[playerCount];
		for(int i= 0 ; i < playerCount; i++){
			System.out.println("Name of player "+i+1 );
			names[i] = br.readLine();
		}
		Board board =  new Board.BoardBuilder().createPlayerHomeTokenPosition(6,4).createTokenPosition(52, 4).build();
		Game ludoGame = new Game.GameBuilder().createPlayers(2,names).setBoard(board).build();
		

	}

}
