package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryMulitpleOf3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase =  Integer.parseInt(br.readLine());
		while(testCase > 0){
			int oddPlaceSum = 0;
			int evenPlaceSum = 0;
			String testData = br.readLine();
			for(int j = 0; j< testData.length();j++){
				if( j%2 == 0){
					evenPlaceSum+=Integer.parseInt(String.valueOf(testData.charAt(j)));
				}else{
					oddPlaceSum+=Integer.parseInt(String.valueOf(testData.charAt(j)));
				}
					
			}
			if( (evenPlaceSum - oddPlaceSum) % 3 ==0){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
			testCase--;
		}

	}

}
