package bst;
import java.util.*;
public class Tree1 {

	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public static Node insert(Node root, int val) {  		// TC: O(height)
		if(root == null) {
			root = new Node(val);
			return root;
		}
		
		if(root.data > val) {
			// insert into left subtree
			root.left = insert(root.left, val);
		}
		else {
			// insert into right subtree
			root.right = insert(root.right, val);
		}
		
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static boolean search(Node root, int key) {  		// TC: O(height)
		if(root == null) {
			return false;
		}
		
		if(root.data > key) {
			return search(root.left, key);
		}
		else if(root.data == key) {
			return true;
		}
		else {
			return search(root.right, key);
		}
	}
	
	public static Node delete(Node root, int val) {
		if(root.data > val) {
			root.left = delete(root.left, val);
		}
		else if(root.data < val) {
			root.right = delete(root.right, val);
		}
		else {	// root.data == val
			
			// Case1
			if(root.left == null && root.right == null) {
				return null;
			}
			
			// Case2
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;				
			}
			
			// Case3
			Node IS = inorderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
			
			
		}
		
		return root;
	}
	
	public static Node inorderSuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void printInRange(Node root, int x, int y) {
		if(root == null) {
			return;
		}
		
		if(root.data >= x && root.data <= y) {
			printInRange(root.left, x, y);
			System.out.print(root.data + " ");
			printInRange(root.right, x, y);
		}
		else if(root.data < x) {
			printInRange(root.right, x, y);
		}
		else {		// root.data > y
			printInRange(root.left, x, y);
		}
	}
	
	public static void printPath(ArrayList<Integer> path) {
		for(int i=0;i<path.size();i++) {
			System.out.print(path.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
		if(root == null) return;
		
		path.add(root.data);
		
		if(root.left == null && root.right == null) {		// leaf
			printPath(path);
		}
		else {		// non-leaf
			printRoot2Leaf(root.left, path);
			printRoot2Leaf(root.right, path);
		}
		
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5, 1, 3, 4, 2, 7
		int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;
		
		for(int i=0;i<values.length;i++) {
			root = insert(root, values[i]);
		}
		
		inOrder(root);
		System.out.println();
		
		if(search(root,7)) {
			System.out.println("Found");
		}
		else {
			System.out.println("Not found");
		}
		
		delete(root, 4);
		inOrder(root);
		System.out.println();
//		delete(root, 10);
//		inOrder(root);
//		System.out.println();
//		delete(root, 5);
//		inOrder(root);
//		System.out.println();
		
		printInRange(root, 6, 10);
		System.out.println();
		System.out.println("All the paths from the root node: ");
		printRoot2Leaf(root, new ArrayList<Integer>() );
	}

}
