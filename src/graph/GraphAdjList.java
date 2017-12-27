package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.attribute.IntegerSyntax;

//Undirected graph
public class GraphAdjList {
	public static class Graph{
		int V;
		public LinkedList<Integer> adjListArray[];
	public Graph(int V){
			this.V = V;
			this.adjListArray = new LinkedList[V];
			for (int i = 0; i < this.V ; i++){
				this.adjListArray[i] = new LinkedList<Integer>();
			}
		}
	}
	public static void addEdge(Graph graph,int src, int dest){
		graph.adjListArray[src].addFirst(dest);
		graph.adjListArray[dest].addFirst(src);
	}
	static void printGraph(Graph graph)
    {       
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }
	public static void dfsUtil(int v,boolean[] visited,Graph g){
		visited[v] = true;
		System.out.print(v+" ");
		Iterator<Integer> iterator = g.adjListArray[v].listIterator();
		while(iterator.hasNext()){
			v = iterator.next();			
			if(!visited[v]){
				dfsUtil(v,visited,g);
			}
		}
		
	}
	
	public static void graphDFS(Graph g,int v,int V){
		boolean[] visited = new boolean[V];
//		for( int i =0 ; i < V ; i++){
//			if(!visited[v]){
//				dfsUtil(i,visited,g);
//			}
//		}
		dfsUtil(v,visited,g);
	}


	public static void graphBFS(Graph g, int v, int V){
		boolean[] visited = new boolean[V];
		//printLevelGraph(g,1);
		visited[v] = true;		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		while(queue.size()!=0){
			v = queue.poll();
			System.out.print(v + " ");
			Iterator<Integer> listIterator = g.adjListArray[v].iterator();
			while(listIterator.hasNext()){
				int n = listIterator.next();
				if(!visited[n]){
					visited[n] = true; 
					queue.add(n);
				}			
			}
		}
		
	}
	public static void main(String []arg){
		// create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
//		Graph g = new Graph(4);
//		 
//        addEdge(g,0, 1);
//        addEdge(g,0, 2);
//        addEdge(g,1, 2);
//        addEdge(g,2, 0);
//        addEdge(g,2, 3);
//        addEdge(g,3, 3);
        // print the adjacency list representation of 
        // the above graph
        printGraph(graph);
        graphDFS(graph, 2, V);
        System.out.println("\n BFS");
        graphBFS(graph, 2, V);
	}
}
