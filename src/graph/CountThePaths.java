package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class CountThePaths {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases =  Integer.parseInt(br.readLine());
		while(testCases>0){
			String[] edgeVertice  = br.readLine().split("\\s");
			LinkedList<Integer>[] graphAdjList =  new LinkedList[Integer.parseInt(edgeVertice[0])];
			String[] edgeInGraph =  br.readLine().split("\\s");
			for(int i = 0; i< edgeInGraph.length;i+=2){
				if(graphAdjList[Integer.parseInt(edgeInGraph[i])] == null){
					graphAdjList[Integer.parseInt(edgeInGraph[i])] =  new LinkedList<Integer>();
				}
				graphAdjList[Integer.parseInt(edgeInGraph[i])].add(Integer.parseInt(edgeInGraph[i+1]));
			}
			String[] testInput = br.readLine().split("\\s");
			Integer pathCount = 0;
			if(graphAdjList[Integer.parseInt(testInput[0])] == null){
				System.out.println(0);
			}else{
				Iterator<Integer> it = graphAdjList[Integer.parseInt(testInput[0])].iterator();
				while(it.hasNext()){
					boolean[] visited =  new boolean[Integer.parseInt(edgeVertice[0])];
					visited[Integer.parseInt(testInput[0])] = true;
					int next = (int)it.next();
					dfsGraph(graphAdjList, next, visited,Integer.parseInt(testInput[1]),pathCount);
				}			
			}
			System.out.println(pathCount);
			testCases--;
		}
	}
	
	public static void dfsGraph(LinkedList[] graph,int sourceEdge,boolean[] visited,int destinationEdge, Integer pathCount ){
		Iterator<Integer> it = graph[sourceEdge].iterator();
		while(it.hasNext()){
			int current = it.next();			
			if(current ==  destinationEdge){
				pathCount++;
				return;
			}
			if(graph[current]==null){
				return;
			}
			if(!visited[current]){
				 dfsGraph(graph, current, visited, destinationEdge, pathCount);
			}			
		}
	}

}
