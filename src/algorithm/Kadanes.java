package algorithm;


//Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
// 
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
// 
//Output:
//Print the maximum sum of the contiguous sub-array in a separate line for each test case.
// 
//Constraints:
//1 ≤ T ≤ 200
//1 ≤ N ≤ 1000
//-100 ≤ A[i] <= 100
// 
//Example:
//Input
//2
//3
//1 2 3
//4
//-1 -2 -3 -4
//Output
//6
//-1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadanes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int testCases = 0;
		testCases =  Integer.parseInt(br.readLine());			
		for(int k = 0; k < testCases ; k++){
			int testDataArrayLength = Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");
			int max_so_far = Integer.MIN_VALUE;
			int max_till_now = 0;
			for(int j = 0; j < testDataArray.length ; j++){
				max_till_now += Integer.parseInt(testDataArray[j]);
				if(max_till_now >  max_so_far){
					max_so_far = max_till_now;
				}
				if(max_till_now < 0){
					max_till_now = 0 ;
				}
				
			}
			System.out.println(max_so_far);
		}
	}

}
