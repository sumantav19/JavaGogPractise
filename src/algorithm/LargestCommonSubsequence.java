package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestCommonSubsequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCases ; i ++){
		    String[] testDataArray = br.readLine().split(" ");
		    String a = testDataArray[0];
		    String b = testDataArray[1];
		    int j  = a.length()-1;
		    int k = b.length()-1;
		    if(hasSubsequence(a, b, j, k) >0 ){
		    	System.out.println(1);
		    }else{
		    	System.out.println(0);
		    }
		}
	}
	public static int hasSubsequence(String a, String b, int currentIndexOfA, int currentIndexOfB){		
		if(a.length()<=0 || b.length()<=0 || currentIndexOfA < 0 || currentIndexOfB < 0){
			return 0;
		}
		if(a.charAt(currentIndexOfA) == b.charAt(currentIndexOfB)){				
			// this extra check is added to return when sequence is found			
			return (1 + hasSubsequence(a, b, currentIndexOfA-1, currentIndexOfB-1));						
		}
		return  Integer.max(hasSubsequence(a, b, currentIndexOfA-1, currentIndexOfB),
			 hasSubsequence(a, b, currentIndexOfA, currentIndexOfB-1));		
	}

}
