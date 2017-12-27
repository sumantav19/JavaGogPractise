package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

import graph.GraphAdjList;
import graph.GraphAdjList.Graph;

public class AlienDictionary {
	public static void addEdge(Graph graph,int src, int dest){
		graph.adjListArray[src].addFirst(dest);
		//graph.adjListArray[dest].addFirst(src);
	}
	public static void dfsUtil(int v,boolean[] visited,Graph g,Stack<Integer> tempStack){
		visited[v] = true;
		//System.out.print(String.valueOf((char)(97+v)));
		Integer i;
		Iterator<Integer> iterator = g.adjListArray[v].listIterator();
		while(iterator.hasNext()){
			i = iterator.next();			
			if(!visited[i]){
				dfsUtil(i,visited,g,tempStack);
			}
		}
		tempStack.push(v);		
	}
	
	public static void graphDFS(Graph g,int v,int V){
		boolean[] visited = new boolean[V];
		Stack<Integer>  tempStack = new Stack<Integer>();
		for( int i =0 ; i < V ; i++){
			if(!visited[i]){
				dfsUtil(i,visited,g,tempStack);
			}
		}
		while(!tempStack.isEmpty()){
			System.out.print(String.valueOf((char)(97+tempStack.pop())));
		}
		//dfsUtil(v,visited,g);
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int testCases = 0;
		testCases =  Integer.parseInt(br.readLine());			
		for(int k = 0; k < testCases ; k++){			
			String[] arrTemp = br.readLine().split(" ");
			int wordCount =  Integer.parseInt(arrTemp[0]);
			int size = Integer.parseInt(arrTemp[1]);
			arrTemp = br.readLine().split(" ");
			Graph graph = new Graph(size);
			int vertex = arrTemp[0].charAt(0) - 'a';			
			for(int i = 0 ; i < arrTemp.length-1 ; i ++){
				//compare till first mismatch and put the edge in graph
				for(int j = 0 ; j < arrTemp[i].length(); j++){
					if(arrTemp[i].charAt(j)!= arrTemp[i+1].charAt(j)){
						addEdge(graph,(arrTemp[i].charAt(j)-'a'),(arrTemp[i+1].charAt(j)-'a'));
						break;
					}
				}
			}
			graphDFS(graph, vertex, size);
			System.out.println();
		}
		
	}
	
}
