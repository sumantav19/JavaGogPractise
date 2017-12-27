package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class ArrangePositiveNegativeElements  {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int testCases = 0;		
		testCases =  Integer.parseInt(br.readLine());		
		LinkedList<Integer> positiveQueue = new LinkedList<Integer>();
		LinkedList<Integer> negativeQueue = new LinkedList<Integer>();		
		for(int k = 0; k < testCases ; k++){
			int testCaseDataLength = Integer.parseInt(br.readLine());
			int[] testData = new int[testCaseDataLength];			
			String[] arrTemp = br.readLine().split(" ");
			for( int j = 0; j < testCaseDataLength; j++){
				if(Integer.parseInt(arrTemp[j]) >= 0){
					positiveQueue.add(Integer.parseInt(arrTemp[j]));
				}else{
					negativeQueue.add(Integer.parseInt(arrTemp[j]));
				}				
			}
			while(!positiveQueue.isEmpty()){
				System.out.print(positiveQueue.poll()+" ");
				System.out.print(negativeQueue.poll()+" ");
			}
			System.out.println();
		}
	}
}
