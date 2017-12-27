package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array A[] of N integers where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are m students, the task is to distribute chocolate packets such that :
//1. Each student gets one packet.
//2. The difference between the number of chocolates given to the students in packet with maximum chocolates and packet with minimum chocolates is minimum.
//Examples
//Input : A[] = {3, 4, 1, 9, 56, 7, 9, 12} 
//m = 5
//Output: Minimum Difference is 6
//We may pick 3,4,7,9,9 and the output 
//is 9-3 = 6
//Input:
//The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting the no of packets. Then in the next line are N space separated values of the array A[] denoting the values of each packet. The third line of each test case contains an integer m denoting the no of students.
//
//Output:
//For each test case in a new line print the required answer .
//
//Constraints:
//1 <=T<= 100
//1 <=N<= 100
//1 <=A[]<= 100
//1 <=m <=N
//
//Example:
//Input:
//2
//8
//3 4 1 9 56 7 9 12
//5
//7
//7 3 2 4 9 12 56
//3
//Output:
//6
//2
public class ChocolateDistributionProblem {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());		
		while(testCases > 0){
			int testDataLength =  Integer.parseInt(br.readLine());
			String[] testData = br.readLine().split("\\s");
			int numberOfStudent = Integer.parseInt(br.readLine());
			//quick sort the packet content
			quickSort(testData,0,testDataLength-1);
			int leastDifference = Integer.MAX_VALUE;
			for(int i = 0; i < testDataLength-numberOfStudent+1;i++){
				if(Integer.parseInt(testData[i+numberOfStudent-1])- Integer.parseInt(testData[i])
						< leastDifference){
					leastDifference =  Integer.parseInt(testData[i+numberOfStudent-1]) - Integer.parseInt(testData[i]);
				}
			}
			System.out.println(leastDifference);
			testCases--;
		}
		
		
	}
	//handle string array containing number 
	public static void quickSort(String[] arr,int low,int high){
		if(low <  high){
			int pi =  partition(arr, low, high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
	}
	public static int partition(String[] arr, int low, int high){
		int pivot = Integer.parseInt(arr[high]);
		int i = low-1;
		for(int j = low; j< high; j++){
			if(Integer.parseInt(arr[j]) < pivot){
				swap(arr,++i,j);
			}
		}
		swap(arr,++i,high);
		return i;
	}
	public static void swap(String[] arr, int i, int j){
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
