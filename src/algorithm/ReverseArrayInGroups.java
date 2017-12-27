package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayInGroups {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases > 0 ){
			int testDataLength =  Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");			
			int k = Integer.parseInt(br.readLine());
			for(int i = 0; i*k < testDataLength; i++){
				if((i+1)*k<testDataLength){
					reverse(testDataArray,i*k,(i+1)*k-1);
				}else{
					reverse(testDataArray,i*k,testDataLength-1);
				}				
			}
			for(int i=0;i<testDataLength;i++){
				System.out.print(testDataArray[i]);
			}
			testCases--;
		}
	}
	public static void reverse(String[] arr,int lowKey, int highKey){
		while(lowKey <  highKey){
			swap(arr,lowKey,highKey);
			lowKey++;
			highKey--;
		}
	}
	public static void swap(String[] arr,int i,int j){
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
