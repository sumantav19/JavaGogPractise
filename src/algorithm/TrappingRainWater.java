package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.attribute.TextSyntax;

//Given n non-negative integers in array representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//For example:
//Input:
//3
//2 0 2
//Output:
//2
//Structure is like below
//|  |
//|_|
//We can trap 2 units of water in the middle gap.
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
//Each test case contains an integer N followed by N numbers to be stored in array.
//
//Output:
//Print trap units of water in the middle gap.
//
//Constraints:
//1<=T<=100
//3<=N<=100
//0<=Arr[i]<10
//
//Example:
//Input:
//2
//4
//7 4 0 9
//3
//6 9 9
//
//Output:
//10
// 0
public class TrappingRainWater {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases>0){
			int testDataLength = Integer.parseInt(br.readLine());
			String[] testData =  br.readLine().split("\\s");
			// store largest from right in O(n)
			int maxTillNowFromRight =  Integer.parseInt(testData[testDataLength-1]);
			int[] maxFromRightArray = new int[testDataLength];
			maxFromRightArray[testDataLength-1] =  maxTillNowFromRight;
			for(int j = testDataLength-2; j >=0; j--){
				if( maxTillNowFromRight < Integer.parseInt(testData[j])){
					maxTillNowFromRight =  Integer.parseInt(testData[j]);
				}
				maxFromRightArray[j] = maxTillNowFromRight;
			}
			//compare from left
			int waterFilled = 0;
			int waterCounter = 0;
			for(int j = 0; j < testDataLength-2;j++){
				int current  = Integer.parseInt(testData[j]);
				waterCounter = current;
				while(current == maxFromRightArray[j] ){
					waterCounter = maxFromRightArray[j];
					j++;
				}				
				j++;
				current =  Integer.parseInt(testData[j]);
				while(current != maxFromRightArray[j]){
					waterFilled += (waterCounter - current);
					
					j++;
					current = Integer.parseInt(testData[j]);
				}
			}
			System.out.println(waterFilled);
			testCases--;
		}
	}

}
