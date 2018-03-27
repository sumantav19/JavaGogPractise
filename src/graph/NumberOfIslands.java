package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A group of connected 1s forms an island now your task is to complete the method findIslands which returns the no of islands present. The function  takes three arguments the first is the boolean matrix A and then the next two arguments are N and M denoting the size of the matrix A . 
//
//Input:
//The first line of input will be the no of test cases T then T test cases follow. The first line of each test case contains Two space separated integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .
//
//Output:
//The output in the expected output will be the total no of islands present. 
//
//Constraints:
//1<=T<=100
//1<=N,M<=50
//0<=A[][]<=1
//
//Example(To be used only for expected output) :
//Input
//1
//3 3
//1 1 0 0 0 1 1 0 1
//Output
//2
//
//Explanation
//The graph will look like
//1 1 0
//0 0 1
//1 0 1
//Here  two islands will be formed
//First island will be formed by elements { A[0][0] ,  A[0][1], A[1][2], A[2][2] }
//Sec island will be formed by  { A[2][0] } 

public class NumberOfIslands {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases > 0){
			testCases--;
			String[] testMatrixSize = br.readLine().split("\\s");
			int m = Integer.parseInt(testMatrixSize[1]);
			int[] neighbourIndex = {1 , m+1, m, m-1, -1, -m-1 , -m, -m+1};
			String[] testData = br.readLine().split("\\s");
			boolean[] visited =  new boolean[testData.length];
			int islandCount = 0 ;
			for(int i = 0; i < testData.length; i++){
				if(!visited[i] && testData[i].equals("1")){
					dfsNeighbour(testData,i,visited,neighbourIndex);
					islandCount++;
				}
			}
			System.out.println(islandCount);
		}
	}
	public static boolean validIndex(int index, int length){
		if(index > -1 && index <  length){
			return true;			
		}
		return false;
	}
	public static void dfsNeighbour(String[] testGraphMatrix, int index, boolean[] visited, int[] neighbourIndex ){
		visited[index] = true;
		for(int i = 0; i < neighbourIndex.length; i++){
			index  = index + neighbourIndex[i];
			if(validIndex(index, testGraphMatrix.length) && !visited[index] && testGraphMatrix[index].equals("1")){
				dfsNeighbour(testGraphMatrix, index, visited, neighbourIndex);
			}
		}
	}

}
