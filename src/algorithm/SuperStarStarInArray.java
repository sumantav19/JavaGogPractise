package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SuperStarStarInArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner s = null;		
		int testCases = 0;
		//s = new Scanner(br);
		//if(s.hasNext()){
			testCases =  Integer.parseInt(br.readLine());			
		//};		
		for(int k = 0; k < testCases ; k++){
			int testCaseDataLength = Integer.parseInt(br.readLine());
			int[] testData = new int[testCaseDataLength];
			Stack<Integer> starStack = new Stack<Integer>();
			int superStar = -1;
			String[] arrTemp = br.readLine().split(" ");
			for( int j = 0; j < testCaseDataLength; j++){
				testData[j] = Integer.parseInt(arrTemp[j]);				
			}
			starStack.push(testData[testData.length-1]);
			superStar = starStack.peek();
			for(int i = testData.length-2; i >= 0; i--){
				if(starStack.peek() < testData[i] ){
					starStack.push(testData[i]);
					superStar =  testData[i];
				}else if(starStack.peek() == testData[i]){
					superStar = -1;
				}
			}
			while(!starStack.isEmpty()){
				System.out.print(starStack.pop()+" ");
			}
			System.out.println("\n"+superStar);
			
		}
	}

}
