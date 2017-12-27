package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given a String of length N reverse the words in it. Words are separated by dots.
//
//Input:
//The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string containing spaces and characters.
// 
//
//Output:
//For each test case, output a single line containing the reversed String.
//
//Constraints:
//1<=T<=20
//1<=Lenght of String<=2000
//
//
//Example:
//Input:
//2
//i.like.this.program.very.much
//pqr.mno
//
//Output:
//much.very.program.this.like.i
//mno.pqr

public class ReverseWords {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCase; i++){
			
			String temp =  br.readLine();
			String[] testData =  temp.split("\\.");
			String output = testData[0];
			for(int j = 1;j< testData.length; j++){
				output =  testData[j]+"."+output;
			}
			System.out.println(output);
		}
	}
}	
