package algorithm;
//Given an array and a number k where k is smaller than size of array, the task is to find the k’th smallest element in the given array. It is given that all array elements are distinct.

//
//Input:
//
//First Line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
//
//Output:
//
//Corresponding to each test case, print the desired output in a new line.
//
//Constraints:
//
//1<=T<=200
//1<=N<=1000
//K
//
//Expected Time Complexity: O(n)
//
//Example:
//
//INPUT
//2
//6
//7 10 4 3 20 15
//3
//5
//7 10 4 20 15
//4
//
//Output:
//
//7
//15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthSmallestElement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases > 0){
			int testDataLength =  Integer.parseInt(br.readLine());
			String[] testData = br.readLine().split("\\s");
			int k = Integer.parseInt(br.readLine());
			//quick sort the packet content
			quickSelect(testData,0,testDataLength-1,k-1);			
			System.out.println(testData[k-1]);
			testCases--;
		}
	}

	// handle string array containing number
	public static void quickSelect(String[] arr, int low, int high,int k) {
		if (low < high) {
			int pi = partition(arr, low, high);
			if( pi == k){
				return;
			}else if(pi > k){
				quickSelect(arr, low, pi - 1,k);
			}
			else if(pi < k){
				quickSelect(arr,pi+1,high,k);
			}
						
		}
	}

	public static int partition(String[] arr, int low, int high) {
		int pivot = Integer.parseInt(arr[high]);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (Integer.parseInt(arr[j]) < pivot) {
				swap(arr, ++i, j);
			}
		}
		swap(arr, ++i, high);
		return i;
	}

	public static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
