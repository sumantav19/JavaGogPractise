package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LeaderInArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases >0){
			int testDataLength = Integer.parseInt(br.readLine());
			String[] testData = br.readLine().split("\\s");
			int leaderTillNow = Integer.parseInt(testData[testDataLength-1]);
			Stack<Integer> leaderStack = new Stack<Integer>();
			leaderStack.push(leaderTillNow);
			for(int i = testDataLength-2; i >=0 ; i--){
				int current = Integer.parseInt(testData[i]);
				if( current > leaderTillNow){
					leaderTillNow =  current;
					leaderStack.push(leaderTillNow);
				}
			}
			while(!leaderStack.isEmpty()){
				System.out.print(leaderStack.pop()+" ");
			}
			System.out.println();
			testCases--;
		}

	}

}
