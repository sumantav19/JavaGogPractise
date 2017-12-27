package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.EmptyStackException;
import java.util.Stack;

//Given a non-negative number N in the form of string. The task is to apply at most one swap operation on the number N so that the resultant is the next higher number.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a number N as input.
//
//Output:
//For each test case, print the next higher number possible. if it is not possible to make next higher number then print "-1".
//
//Constraints:
//1<=T<=100
//2<=|Number length |<=104
//
//Example:
//Input:
//2
//768
//333
//
//Output:
//786
//-1

//Input:
//120000654
//
//Its Correct output is:
//120004650
//
//And Your Code's Output is:
//120006054
//Input:
//3033
//
//Its Correct output is:
//3303
//
//And Your Code's Output is:
//3330
public class NextHighestNumberInOneSwap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int testCases  = Integer.parseInt(br.readLine());
		while(testCases>0){
			StringBuilder testNumber = new StringBuilder(br.readLine());
			Stack<Integer> maxStackIndex = new Stack<Integer>();
			StringBuilder tempTestNumber = new StringBuilder(testNumber);
			maxStackIndex.push(testNumber.length()-1);
			for(int i = testNumber.length()-2; i >= 0 ; i--){
				if(testNumber.charAt(i) >= testNumber.charAt(maxStackIndex.peek())){
					maxStackIndex.push(i);
				}else if( testNumber.charAt(i) < testNumber.charAt(maxStackIndex.peek())){
					//swap
					int tempPop = -1;
					try {
						while(testNumber.charAt(i) < testNumber.charAt(maxStackIndex.peek())){
							tempPop = maxStackIndex.pop();
						}
					} catch (EmptyStackException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					char temp  =  testNumber.charAt(i);
					testNumber.setCharAt(i, testNumber.charAt(tempPop));
					testNumber.setCharAt(tempPop, temp);
					break;
				}
				
			}
			//System.out.println(Double.parseDouble(tempTestNumber.toString()));
//			System.out.println(.parseDouble(testNumber.toString()));
			if(tempTestNumber.toString().equals(testNumber.toString())){				
				System.out.println(-1);
			}else{
				System.out.println(testNumber);
			}
				
			testCases--;
		}
	}

}
