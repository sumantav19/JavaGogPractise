package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Write a program to sort an array of 0's,1's and 2's in ascending order.
//
//Input:
//The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.
//
//Output: 
//Print the sorted array of 0's, 1's and 2's.
//
//Constraints: 
//
//1 <= T <= 100
//1 <= N <= 100
//0 <= arr[i] <= 2
//
//Example:
//
//Input :
//
//2
//5
//0 2 1 2 0
//3
//0 1 0
// 
//
//Output:
//
//0 0 1 2 2
//0 0 1

public class SortOs1s2s{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases =  Integer.parseInt(br.readLine());
		for(int i = 0; i <  testCases ;  i ++){
			br.readLine();
			String[] testDataArray = br.readLine().split("\\s");
			int indexStart1 = 0;
			int indexStart2 = testDataArray.length-1;
			for( int j = 0 ; j < testDataArray.length;){
				int current = Integer.parseInt(testDataArray[j]);
				if(current == 0){
					swap(indexStart1,j,testDataArray);
					indexStart1++;
					 j++;
				}else if(current == 1){	
					 j++;
					continue;				
				}else if(current == 2){
					swap(indexStart2,j,testDataArray);
					indexStart2--;					
				}
			}
			for(String test : testDataArray){
				System.out.print(test+" ");
			}
		}
		

	}
	
	public static void swap(int key1 , int key2, String[] stringArray){
		String temp = stringArray[key1];
		stringArray[key1] = stringArray[key2];
		stringArray[key2] = temp;		
	}

}
