package game;

public class Board {
	private Block[][] blockArray;
	
	public Board(Block[][] block) {
		// TODO Auto-generated constructor stub
		blockArray = block;
	}
	public Block[][] getBlockArray() {
		return blockArray;
	}
	
	public void setBlockAtIndex(int row,int column,Player player) throws InvalidMoveException{
		if(blockArray[row][column].getPlayer() != null){
			throw new InvalidMoveException("Block Occupied");
		}
		blockArray[row][column].setPlayer(player);
	}
	
	public void printBoard(){		
		for(int i = 0; i< blockArray.length; i++){
			for(int j =0 ; j< blockArray[i].length; j++){
				System.out.print(blockArray[i][j]+"|");
			}
			System.out.println("\n------");
		}
	}
}
