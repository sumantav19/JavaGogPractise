package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array A your task is to tell at which position the equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.
//
//Input:
//The first line of input contains an integer T denoting the no of test cases then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.
//
//Output:
//For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.
//
//Constraints:
//1<=T<=100
//1<=N<=100
//
//Example:
//Input:
//2
//1
//1
//5
//1 3 5 2 2
//
//Output:
//1
//3
//
//Explanation:
//1. Since its the only element hence its the only equilibrium point
//2. For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2)

public class ArrayEquilibriumPoint {
	
	 

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases >0){
			int testDataArrayLength = Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");
			int sumFromStart = 0, sumFromEnd = 0;
			int[][] sumArray = new int[testDataArrayLength][2];
			for(int i = 0,j = testDataArrayLength-1; i < testDataArrayLength;i++,j--){
				try {
					sumFromStart += Integer.parseInt(testDataArray[i-1]);
					sumFromEnd += Integer.parseInt(testDataArray[j+1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					continue;
				}
				sumArray[i][0] = sumFromStart;
				sumArray[j][1] = sumFromEnd;				
			}
			boolean equilibriumFlag = false;
			for(int i = 0 ; i < testDataArrayLength ; i++){
				if(sumArray[i][0] == sumArray[i][1]){
					System.out.println(i+1);
					equilibriumFlag = true;
					break;
				}
			}
			if(!equilibriumFlag){
				System.out.println(-1);
			}
			testCases--;
		}
	}

}
