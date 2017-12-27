package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ChocolateStation {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		int testCases = 0;		
		testCases =  Integer.parseInt(br.readLine());			
		int carry = 0, price = 0, buy = 0;
		for(int k = 0; k < testCases ; k++){
			int testCaseDataLength = Integer.parseInt(br.readLine());
			int[] testData = new int[testCaseDataLength];			;
			String[] arrTemp = br.readLine().split(" ");
			buy  =  Integer.parseInt(arrTemp[0]);
			for( int j = 1; j < testCaseDataLength; j++){
				carry = Integer.parseInt(arrTemp[j-1]) - Integer.parseInt(arrTemp[j])+ carry;
				if(carry < 0){
					buy = buy - carry;
					carry = 0;
				}
			}
			price = Integer.parseInt(br.readLine());
			System.out.println(price*buy);
		}
	}

}
