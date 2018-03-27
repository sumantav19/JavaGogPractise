package game.game2048;

import java.util.Random;

public class Main2048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Block [][] blockArray2048 = new Block[4][4];
		final int BlOCKCOUNT = 16; 
		int blockDefined = 0;
	}
	public static boolean isBlockArrayIndexUndefined(int i, int j,Block[][] blockArray){
		if(blockArray[i][j] == null){
			return true;
		}
		return false;
	}
	public static int generateRandomBlockIndex(){
		Random  random = new Random();
		return random.nextInt(4);
	}
}
