package tree;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {
	Node root;
	public static class Node{
		char data;
		Node left;
		Node right;
		Node(){
			this.left = null;
			this.right = null;
		}
		Node(char data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	Tree(){
		this.root = new Node();
	}
	Tree(char data){
		this.root = new Node(data);
	}
	public static void treeDFSIterative(Node root){
		if(root == null){
			return;
		}
		Node current = null;
		//System.out.print(root+" ");
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			current = stack.pop();
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
			System.out.print(current.data+" ");			
		}
	}
	//pre order
	public static void treeDFSRecursive(Node root){
		if(root == null){			
			return;
		}
		System.out.print(root.data + " ");
		treeDFSRecursive(root.left);
		treeDFSRecursive(root.right);
	}
	
	public static int getTreeHeight(Node root,int height){
		if(root == null){
			return 0;
		}
		height = Integer.max(
				getTreeHeight(root.left, height),
				getTreeHeight(root.right, height))+1;
		return height;
	}
	public static void treeBFSRecursive(Node root){
		int level = 0;
		while(level < getTreeHeight(root,0)){
			printLevelOrder(root, level);
			level++;
		}
	}
	public static void printLevelOrder(Node root,int level){
		if(root == null){
			return;
		}
		if(level == 0){
			System.out.print(root.data+" ");
			return;
		}
		printLevelOrder(root.left, level - 1);
		printLevelOrder(root.right, level -1);
	}
	public static void treeBFSIterative(Node root){
		if(root == null){
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size() != 0){
			Node current = queue.pop();
			System.out.print(current.data+" ");
			if(current.left!=null){
				queue.add(current.left);
			}
			if(current.right!=null){
				queue.add(current.right);
			}
		}
	}
	// For strict binary tree which contains only roots and two leaves 
	// Construct tree from pre order traversal string example(RRLL)
	public static Node createPreOrderTree(String preOrderString){
		Stack<Node> tempStack =  new Stack<Node>();
		Node tempRoot = new Node();
		tempStack.push(tempRoot);
		int i = 0;
		while( i < preOrderString.length()){
			Node root = tempStack.pop();
			if(preOrderString.charAt(i) == 'R'){
				root.data = 'R';
				root.left = new Node();
				root.right = new Node();
				tempStack.push(root.right);
				tempStack.push(root.left);								
			}else if(preOrderString.charAt(i) == 'L'){				
				root.data = 'L';			
			}
			i++;
		}
		return tempRoot;		
	}
	public static void main(String arg[]){
//		Tree tree = new Tree(10);
//		tree.root.left = new Node(5);
//		tree.root.right = new Node(15);
//		tree.root.left.left = new Node(3);
//		tree.root.left.right = new Node(8);
//		tree.root.right.left = new Node(12);
//		tree.root.right.right = new Node(18);
//		tree.root.left.left.left = new Node(1);
//		treeDFSIterative(tree.root);
//		System.out.println();
//		treeDFSRecursive(tree.root);
//		System.out.println();
//		System.out.println("\nHeight of tree is " + getTreeHeight(tree.root, 0));
//		treeBFSRecursive(tree.root);
//		System.out.println();
//		treeBFSIterative(tree.root);
		Tree tempTree = new Tree();
		tempTree.root = createPreOrderTree("RRRLLRLLRRLLRLL");
		treeBFSIterative(tempTree.root);
	}
}
