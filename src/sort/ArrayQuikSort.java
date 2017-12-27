package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayQuikSort {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases > 0 ){
			int testDataLength =  Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");			
			quickSort(testDataArray,0, testDataLength-1);
			for(int i = 0; i < testDataLength;i++){
				System.out.print(testDataArray[i]+" ");
			}
			testCases--;
		}
	}
	public static void quickSort(String[] arr,int low, int high){
		
		if(low < high){
			int pivot =  partition(arr, low, high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
	}
	public static int partition(String[] arr,int low,int high){
		int pivot = Integer.parseInt(arr[high]);
		int i = low-1;		
		for(int j = low; j < high ; j++){
			if(Integer.parseInt(arr[j]) < pivot){
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,++i,high);
		return i;
	}
	public static void swap(String[] arr,int i,int j){
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
