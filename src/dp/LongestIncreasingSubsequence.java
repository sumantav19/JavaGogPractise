package dp;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
        // Write your solution here
		Node root  = new Node(Integer.MIN_VALUE);
		Iterator<Integer> it = sequence.iterator();
		while(it.hasNext()){
			int current = it.next();
			addNode(root, current);
		}		
		
		return null;
    }
	
	public List getLargestSubSeq(Node root){
		
		return null;
	}
	public static void addNode(Node node,int value){
		//Iterator<Node> it = node.nodeList.iterator();
		
		//checks if list has any element
		if(node.nodeList.size() == 0){
			node.nodeList.add(new Node(value));
		}
		//flag to check if list has any smaller than value
		boolean added = false;
		for(Node next : node.nodeList){			
			//could not think of a better implementation			
			
			if(next.value < value){
				addNode(next, value);
				added = true;				
			}
			
		}
		if(!added){
			node.nodeList.add(new Node(value));
		}
	}
//	public static void addUtil(Node node,int value){
//		
//	}
	static class Node{
		List<Node> nodeList;
		int value;
		int sizeCount;
		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.nodeList = new LinkedList<Node>();
			this.value = value;			
		}
				
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<Integer>();
		Integer[] testDataArray = {16, 3, 5, 19, 10, 14, 12, 0, 15};
		Collections.addAll(list, testDataArray);
		longest_increasing_subsequence(list);
	}

}
