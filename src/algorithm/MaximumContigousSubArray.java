package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
//The first line of each test case contains a single integer 'N' denoting the size of array and the size of subarray 'k'.
//The second line contains 'N' space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//Output:
//Print the maximum for every subarray of size k.
//
//Constraints:
//1 ≤ T ≤ 200
//1 ≤ N ≤ 100
//1 ≤ k ≤ N
//0 ≤A[i]<1000
//
//Example:
//
//Input:
//2
//9 3
//1 2 3 1 4 5 2 3 6
//10 4
//8 5 10 7 9 4 15 12 90 13
//
//Output:
//3 3 4 5 5 5 6
//10 10 10 15 15 90 90
public class MaximumContigousSubArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases > 0 ){
			String[] testMetadata = br.readLine().split("\\s");  
			String[] testDataArray = br.readLine().split("\\s");
			int subArraySize = Integer.parseInt(testMetadata[1]);
			int maxIndex =  findMax(testDataArray, 0, subArraySize);			
			System.out.print(testDataArray[maxIndex]+" ");
			int max =  Integer.parseInt(testDataArray[maxIndex]);
			for(int i = subArraySize; i <  Integer.parseInt(testMetadata[0]);i++){
				if( maxIndex <= i- subArraySize){
					maxIndex =  findMax(testDataArray, i-subArraySize+1, i);
					max =  Integer.parseInt(testDataArray[maxIndex]);
				}
				else if(Integer.parseInt(testDataArray[i]) > max){
					max =  Integer.parseInt(testDataArray[i]);
					maxIndex = i;
				}
				System.out.print(max+" ");
			}
			testCases--;
		}
	}
	
	public static int findMax(String[] arr,int low, int high){
		int maxIndex = 0;
		while(low <= high){
			if(Integer.parseInt(arr[low])>Integer.parseInt(arr[maxIndex]))
				maxIndex = low; 
			low++;
		}
		return maxIndex;
	}
}
