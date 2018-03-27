package game.ludo;

//to store the state of the game
public class Board {
	// same player can have multiple token on board
	private Token[][] tokenPosition;
	// Each player will have different home token postion
	private Token[][][] playerHomeTokenPosition;
	// private final int[] startPosition = {0,13,26,39};
	// private final int[] endPosition = {50,11,24,37};

	public Board(BoardBuilder builder) {
		// TODO Auto-generated constructor stub
	}
	// to remove a token from a index and move the remaining token in proper
	// position
	public Token[] selectPlayerToken(int position,Player player){
		// check if player has given valid position
		if(tokenPosition[position][0] != null || !tokenPosition[position][0].getColour().equals(player.getColour())){
			try {
				throw new InvalidMoveException("You don't have a token there");
			} catch (InvalidMoveException e) {
				// TODO Auto-generated catch block
				System.out.println("Select correct token");
			}
		}
		return tokenPosition[position];
	}
	public void moveToken(int position,int diceThrow) {
		
		// moves all the token present at that position back to start
		// check if the token is for some other player
		// checked by token color
		
		if(tokenPosition[diceThrow+position][0]!= null){
			if(!tokenPosition[diceThrow+position][0].getColour().equals(tokenPosition[position][0].getColour())){
				for(int i =0; tokenPosition[position][i] != null;i++){
					move(diceThrow+position,-1);
				}				
			}				
		}
		move(position, diceThrow+position);
	}
	
	public void removeAllToken(int position){
		tokenPosition[position] =  null;
	}
	
	// move the last token at that positiom
	public void move(int position, int moveTo) {
		// moveTo = -1 when reset token back start
		// change position of token and update the position on token
		int i = 0;
		while (i < tokenPosition[position].length && tokenPosition[position][i] != null) {
			i++;
		}
		i--;
		if (moveTo != -1) {
			tokenPosition[moveTo][i] = tokenPosition[position][i];
		}
		tokenPosition[position][i] = null;

	}
	
	public static class BoardBuilder{
		private Token[][] tokenPostion;
		private Token[][][] playerHomeTokenPosition;
		
		public BoardBuilder createTokenPosition(int tokenMovesCount,int playerTokenCount){
			this.tokenPostion = new Token[tokenMovesCount][playerTokenCount];
			return this;
		}
		public BoardBuilder createPlayerHomeTokenPosition(int tokenHomeMovesCount,int playerTokenCount){
			this.tokenPostion = new Token[tokenHomeMovesCount][playerTokenCount];
			return this;
		}
		
		public Board build(){
			return new Board(this);
		}
	}
}
