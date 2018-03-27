package game;

public class TicTacToeGame extends GameBuilder {	
	
	private final static int PLAYERCOUNT = 2;
	private final static int BOARDSIZE = 3;
	private Player[] player; 
	private Player winningPlayer;
	
	
	public Player getWinningPlayer() {
		return winningPlayer;
	}

	private void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	public TicTacToeGame() {
		// TODO Auto-generated constructor stub
		Block[][] gameBlockArray= new Block[BOARDSIZE][BOARDSIZE];
		for(int i = 0; i< BOARDSIZE; i++){
			for(int j =0 ; j< BOARDSIZE; j++){
				gameBlockArray[i][j] =  new Block();
			}
		}
		createGame(new Board(gameBlockArray),TicTacToeGameState.GAME_ON);
		player =  new Player[PLAYERCOUNT];
	}
	
	@Override
	public void checkGameState(int row,int column,Player player) {
		// TODO Auto-generated method stub
		Block[][] block = getGameBlockArray();
		try {
			int count = 0;
			for (int i = 0; i < BOARDSIZE; i++) {
				if (block[i][column].getPlayer().equals(player)) {
					++count;
				}
			}
			checkCount(count,player);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			int count = 0;
			for (int i = 0; i < BOARDSIZE; i++) {
				if (block[row][i].getPlayer().equals(player)) {
					++count;
				}
			}
			checkCount(count,player);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			int count = 0;
			for (int i = 0; i < BOARDSIZE; i++) {
				if (block[i][i].getPlayer().equals(player)) {
					++count;
				}
			}
			checkCount(count,player);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			int count = 0;
			for(int i = 0,j=BOARDSIZE; i < BOARDSIZE ; i++){			
				if(block[j-1-i][i].getPlayer().equals(player)){
					++count;
				}
			}
			checkCount(count,player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	private void checkCount(int count,Player player) {
		if(count == 3){
			this.setGameState(TicTacToeGameState.GAME_WIN);
			this.setWinningPlayer(player);
		}
	}
	
	//
	public boolean checkPlayerCount(Player player){
		// initially initialize the player Array with different Players
		for(int i = 0 ; i < PLAYERCOUNT ; i++){
			if(this.player[i] == null){
				this.player[i] = player;
				return true;
			}else if(this.player[i].equals(player)){
				return true;
			}
		}
		return false;
	}
	// Check if player move is valid for game rule
	@Override
	public boolean checkPlayerMove(int row, int column, Player player) throws InvalidMoveException {
		// TODO Auto-generated method stub
		if(checkPlayerCount(player)){
			return true;
		}
		throw new InvalidMoveException("Only two player "+player.getName() );
	}

}
