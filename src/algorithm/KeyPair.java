package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array A[] of n numbers and another number x, 
//determine whether or not there exist two elements in A whose 
//sum is exactly x.
//Constraints:
//
//1 ≤ T ≤ 200
//1 ≤ N ≤ 200
//1 ≤ C[i] ≤ 1000
//
//Example:
//
//Input:
//2
//6 16
//1 4 45 6 10 8
//5 10
//1 2 4 3 6
//
//Output:
//Yes
//Yes

public class KeyPair {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <  testCases ; i++){
			String[] testData = br.readLine().split(" ");			
			int sum = Integer.parseInt(testData[1]);
			boolean[] indexArray = new boolean[sum];
			String [] testArray = br.readLine().split(" ");
			boolean flag =  false;
			for (int j = 0 ; j < Integer.parseInt(testData[0]);j++){
				int temp = Integer.parseInt(testArray[j]);
				if(temp < sum ){
					if( indexArray[temp]){
						System.out.println("Yes");
						flag = true;
						break;
					}
					//indexArray[temp] =  true;
					indexArray[sum - temp] = true;
				}				
			}
			if(!flag){
				System.out.println("No");
			}
		}
	}
}
