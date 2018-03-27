package algorithm;
//Given two array A1[] and A2[], sort A1 in such a way that the
// relative order among the elements will be same as those  in A2. For the elements not present in A2. 
//Append them at last in sorted order. It is also given that the number of elements in A2[] are smaller 
//than or equal to number of elements in A1[] and A2[] has all distinct elements

//Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
//A2[] = {2, 1, 8, 3}
//Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
//Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], 
//then all occurrences 1s as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3.  
//Finally we print all those elements of A1[] that are not present in A2[]
//		 
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases. 
//The first line of each test case is M and N.  M is the number of elements in A1 and 
//N is the number of elements in A2.
//The second line of each test case contains M elements. The third line of each test case contains N elements.
//
//Output:
//
//Print the sorted array according order defined by another array.
//
//Constraints:
//
//1 ≤ T ≤ 50
//1 ≤ M ≤ 50
//1 ≤ N ≤ 10 & N ≤ M
//1 ≤ A1[i], A2[i] ≤ 1000
//
//Example:
//
//Input:
//1
//11 4
//2 1 2 5 7 1 9 3 6 8 8
//2 1 8 3
//
//Output:
//2 2 1 1 8 8 3 5 6 7 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RelativeSorting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases > 0) {
			String[] testDataArrayLength = br.readLine().split("\\s");
			String[] testDataArray1 = br.readLine().split("\\s");
			String[] testDataArray2 = br.readLine().split("\\s");
			// extra space to store the element not present in 1 st array
			@SuppressWarnings("unchecked")
			List<String>[] outputList = new LinkedList[Integer.parseInt(testDataArrayLength[1]) + 1];
			//O(n*m) max 500 as per constraint
			// this for groups the element 
			for (int i = 0; i < testDataArray1.length; i++) {
				if (outputList[getIndex(testDataArray2, testDataArray1[i])] == null) {
					outputList[getIndex(testDataArray2, testDataArray1[i])] = new LinkedList<String>();
				}
				outputList[getIndex(testDataArray2, testDataArray1[i])].add(testDataArray1[i]);
			}
			// prints the  list
			for (int i = 0; i < outputList.length - 1; i++) {
				// condition is present if there is a extra element in 2nd array which is not present in the first array
				if(outputList[i]==null){
					continue;
				}
				Iterator<String> it = outputList[i].iterator();
				
				while (it.hasNext()) {
					System.out.print(it.next() + " ");
				}
			}
			// to sort the remaining element not present in 2nd array
			if (outputList[testDataArray2.length] != null) {
				String[] extraElement = new String[outputList[testDataArray2.length].size()];
				extraElement = outputList[testDataArray2.length].toArray(extraElement);
				quickSort(extraElement, 0, extraElement.length-1);
				for(int i = 0; i < extraElement.length; i++){
					System.out.print(extraElement[i]+" ");
				}
			}			
			
			System.out.println();
			testCases--;
		}
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
	// O(n) complexity as the constraint says only 10 element will be there in 2nd array
	public static int getIndex(String[] arr, String value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) {
				return i;
			}
		}
		// return extra space index if not present in array intead of
		return arr.length;
	}

}
