package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumPlatform {

	public static void main(String[] args) throws NumberFormatException,IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());		
		while(testCases >0){
			int testDataLength = Integer.parseInt(br.readLine());
			int minimumPlatform = 1;
			String[][] testData = 
				{br.readLine().split("\\s"),br.readLine().split("\\s")};
			for(int i = testDataLength-1; i > 0; i--){
				int currentCount = 0;
				try{
					int currentArrival = Integer.parseInt(testData[i][0]);
					int currentDeparture = Integer.parseInt(testData[i][1]);
					while(i>0){
						int previousArival =Integer.parseInt(testData[i-1][0]);
						int previousDeparture =Integer.parseInt(testData[i-1][0]);
						if(currentArrival <= previousDeparture && 
								currentArrival >= previousArival ){
							
						}
					}
				}catch(IndexOutOfBoundsException e){
					continue;
				}
			}
		}

	}

}
