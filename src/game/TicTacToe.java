package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	public int test;
	public final static int maxNumberOfInput = 9;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Tic tac toe. Input in row and column with space.\n"
				+ "Enter the row number and column number.\n"
				+ "Example:\n"
				+ "For row 0 column 0 Enter 0 0 and enter.");
		Integer[][] ticTackToeMatrix = new Integer[3][3];
		// Initialize matrix with 1, 2
		// 1 for player1
		// 2 for player2
		
		for(int i = 0; i < maxNumberOfInput;){
			//check if input is already intialized;
			String[] input = br.readLine().split("\\s");
			try {
				if(ticTackToeMatrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])] != null){				
					System.out.println("Already occupied please select another block");
					continue;
				}			
				ticTackToeMatrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = new Integer(i%2);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Please use integer not char or String");
				continue;
			} catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Please use correct input");
				continue;
			}
			printTicTacToeState(ticTackToeMatrix);
			i++;
		}
	}
	public static void printTicTacToeState(Integer[][] ticTackToeMatrix){
		for(int i = 0; i <3 ; i++){
			for(int j = 0; j< 3; j++){
				if(ticTackToeMatrix[i][j]==null){
					System.out.print(" ");
					
				}else if(ticTackToeMatrix[i][j]==1){
					System.out.print("X");
				}else{
					System.out.print("O");
				}
				System.out.print("|");
			}
			System.out.println("\n-------");
		}
	}
	

}
