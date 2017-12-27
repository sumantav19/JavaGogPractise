package algorithm;
//Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order.
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases.
//The first line of each test case is N,N is the size of array.
//The second line of each test case contains N input A[].
//
//Output:
//
//Print the sum of maximum sum sequence of the given array.
//
//Constraints:
//
//1 ≤ T ≤ 100
//1 ≤ N ≤ 100
//1 ≤ A[] ≤ 1000
//
//Example:
//
//Input:
//2
//7
//1 101 2 3 100 4 5
//4
//10 5 4 3
//
//Output:
//106
//10
//
//Explanation:
//For input:
//7
//1 101 2 3 100 4 5
//All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), 
//out of this (1,2,3,100) has maximum sum,i.e., 106. Hence the output
//is stated as 106.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases >0){
			int testDataArrayLength = Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");
			int[][] maxSumArray = new int[testDataArrayLength][2];
			for(int i=0; i< testDataArrayLength ; i++){
				int maxSmallerThanCurrent = 0;
				int sumTillNowForMaxSmallerThanCurrent = 0;
				int current = Integer.parseInt(testDataArray[i]);
				for(int j = 0; maxSumArray[j][0] !=0 && j < testDataArrayLength ;j++){
					if( maxSumArray[j][0] < current && maxSmallerThanCurrent < maxSumArray[j][0]){
						maxSmallerThanCurrent = maxSumArray[j][0];
						sumTillNowForMaxSmallerThanCurrent = maxSumArray[j][1];
					}					
				}
				maxSumArray[i][0] = current;
				maxSumArray[i][1] = current + sumTillNowForMaxSmallerThanCurrent;
			}
			int max = 0;
			for(int i =0; i< testDataArrayLength ;i++){
				if(maxSumArray[i][1]>max){
					max = maxSumArray[i][1];
				}
			}
			System.out.println(max);
			testCases--;
		}
	}

}
