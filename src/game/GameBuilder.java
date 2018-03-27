package game;

public abstract class GameBuilder {
	private Board gameBoard;
	private State gameState;
	
	
	public State getGameState() {
		return gameState;
	}
	public void setGameState(State gameState) {
		this.gameState = gameState;
	}
	public void createGame(Board board,State gameState){
		gameBoard = board;
		this.gameState =  gameState;
	}
	public void printBoard(){
		gameBoard.printBoard();
	}
	public void playerMove(int row, int column,Player player) throws InvalidMoveException{
		if(checkPlayerMove(row, column, player)){
			gameBoard.setBlockAtIndex(row, column, player);
			checkGameState(row, column, player);
		}
		
	}
	public Block[][] getGameBlockArray(){
		return gameBoard.getBlockArray();
	}

		
	public abstract boolean checkPlayerMove(int row,int column, Player player)throws InvalidMoveException;	
	public abstract void checkGameState(int row,int column,Player player);
}
