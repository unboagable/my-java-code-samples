package solutions;

import java.util.ArrayList;
import java.util.Random;

import structures.BinaryTreeNode;
import structures.LinkedListNode;

public class TreesAndGraphs {
	static Random random = new Random();

	//ctci:P2.1
	public static boolean isBalanced(BinaryTreeNode root) {
		return isBalancedRecursive(root) >= 0;
	}
	
	private static int isBalancedRecursive(BinaryTreeNode root) {
		if(root == null) { 
			return 0;
		}
		
		if(root.left == null && root.right == null) {  //leaf
			return 1;
		}
		
		if(root.left == null) {
			if(isBalancedRecursive(root.right) == 1) { //right is leaf
				return 2;
			}
			return -1;
		}
		
		if(root.right == null) {
			if(isBalancedRecursive(root.left) == 1) { //left is leaf
				return 2;
			}
			return -1;
		}
		int left = isBalancedRecursive(root.left);
		int right = isBalancedRecursive(root.right);
		if(left == -1 || right == -1 || Integer.max(left-right, right-left)>1) {
			return -1;
		}
		return 1+Integer.max(left, right);
	}
	
	//ctci:P4.3
	public static BinaryTreeNode makeTree(int[] num){
		
		if(num == null || num.length == 0){
			return null;
		}
		
		return makeTreeRecursive(num, 0, num.length);
	}
	
	//s inclusive, e exclusive
	private static BinaryTreeNode makeTreeRecursive(int[] num, int s, int e){
		if(e-s == 0){
			return null;
		}else if (e-s == 1){
			return new BinaryTreeNode(num[s]);
		}
		
		BinaryTreeNode r;
		
		if(e-s == 2){
			if(random.nextInt(2)==1){
				r=new BinaryTreeNode(num[s]);
				r.right=new BinaryTreeNode(num[s+1]);
			}else{
				r=new BinaryTreeNode(num[s+1]);
				r.left=new BinaryTreeNode(num[s]);
			}
		}else{
			int mid=((e-s)/2)+s;
			r=new BinaryTreeNode(num[mid]);
			r.left=makeTreeRecursive(num, s, mid);
			r.right=makeTreeRecursive(num, mid+1, e);
		}
		
		return r;
		
	}
	
	//ctci:4.4
	public static LinkedListNode[] linkedListPerDepth(BinaryTreeNode bst){
		if(bst == null) {
			return new LinkedListNode[0];
		}
		ArrayList<LinkedListNode> arr=new ArrayList<LinkedListNode>();
		arr = linkedListPerDepthRecursive(bst, arr, 1);
		
		LinkedListNode[] sol = new LinkedListNode[arr.size()];
		return arr.toArray(sol);
	}
	
	private static ArrayList<LinkedListNode> linkedListPerDepthRecursive(
			BinaryTreeNode bst, ArrayList<LinkedListNode> arr, int d){
		if (bst == null) {
			return arr;
		}
		
		if(arr.size() < d) {
			arr.add(new LinkedListNode(bst.val));
		}else{
			arr.get(d-1).appendToTail(bst.val);
		}
		
		if(bst.left != null) {
			arr = linkedListPerDepthRecursive(bst.left, arr, d+1);
		}
		
		if(bst.right != null) {
			arr = linkedListPerDepthRecursive(bst.right, arr, d+1);
		}
		
		return arr;
	}
	
	// p4.6 Design an algorithm and write code to find the first common ancestor of two nodes
	// in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
	// necessarily a binary search tree.

	//preorder-traversal (left and right first) compare lists
	
	
}
