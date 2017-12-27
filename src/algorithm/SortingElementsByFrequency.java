package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array of integers, sort the array according to frequency of elements. For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}. 
//
//If frequencies of two elements are same, print them in increasing order.
//
// 
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//
//Output:
//
//Print each sorted array in a seperate line. For each array its numbers should be seperated by space.
//
//
//Constraints:
//
//1 ≤ T ≤ 70
//30 ≤ N ≤ 130
//1 ≤ A [ i ] ≤ 60 
//
//
//Example:
//
//Input:
//
//1
//5
//5 5 4 6 4
//
//Output:
//
//4 4 5 5 6 

public class SortingElementsByFrequency {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases > 0) {
			int testDataLength = Integer.parseInt(br.readLine());
			String[] testData = br.readLine().split("\\s");
			String[][] frequecyData = new String[testDataLength][2];
//			for (int i = 0; i < testDataLength; i++) {
//				//if(getIndex(frequecyData, testData[i]))
//			}
			testCases--;
		}
	}

	// O(n) complexity as the constraint says only 10 element will be there in
	// 2nd array
	public static int getIndex(String[][] arr, String value) {
		int i = 0;
		for (;i < arr.length && arr[i] != null; i++) {
			if (arr[i][0].equals(value)) {
				return i;
			}
		}
		// return extra space index if not present in array intead of
		return i;
	}

	public static void quickSort(String[] arr, int low, int high) {

		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	public static int partition(String[] arr, int low, int high) {
		int pivot = Integer.parseInt(arr[high]);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (Integer.parseInt(arr[j]) < pivot) {
				i++;
				swap(arr, i, j);
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
