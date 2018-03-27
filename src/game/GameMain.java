package game;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeGame game = new TicTacToeGame();
		
		Player player1 =  new Player("Sumant");
		Player player2 = new Player("Nishant");
		
		
		
		
		try {
			game.playerMove(0,2, player1);
			game.playerMove(0,1, player2);
			game.playerMove(1,1, player1);
			game.playerMove(2,0, player1);
			game.printBoard();
			System.out.println(game.getGameState());
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
