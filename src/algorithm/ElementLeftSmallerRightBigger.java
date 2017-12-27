package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
//
//Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated array elements.
//
//Output:
//For each test case, in a new line print the required element. If no such element present in array then print -1.
//
//Constraints:
//1<=T<=100
//3<=N<=106
//1<=A[i]<=106
//
//Example:
//Input:
//3
//4
//4 2 5 7
//3
//11 9 12
//6
//4 3 2 7 8 9
//
//Output:
//5
//-1
//7
public class ElementLeftSmallerRightBigger {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases >0){
			int testDataArrayLength = Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");
			int[] rightMinArray =  new int[testDataArrayLength];
			int minElementFromRight =  Integer.parseInt(testDataArray[testDataArrayLength-1]);
			rightMinArray[testDataArrayLength-1] = minElementFromRight;
			//store smallest from right
			for(int j = testDataArrayLength-2; j>=0; j--){
				if(Integer.parseInt(testDataArray[j])<minElementFromRight){
					minElementFromRight =  Integer.parseInt(testDataArray[j]);
					rightMinArray[j] = minElementFromRight;
				}
			}
			//compare if largest from left is equal to smallest from right
			int count = 0;
			int largestElementFromLeft = 0;
			for(int i =0; i < testDataArrayLength-1 ; i++){
				if(largestElementFromLeft < Integer.parseInt(testDataArray[i]) ){
					largestElementFromLeft  = Integer.parseInt(testDataArray[i]);
				}
				if(largestElementFromLeft == rightMinArray[i]){
					System.out.print(largestElementFromLeft);
					count++;
					break;
				}
			}
			if(count==0){
				System.out.print(-1);
			}
			System.out.println();
			testCases--;
		}
	}

}
