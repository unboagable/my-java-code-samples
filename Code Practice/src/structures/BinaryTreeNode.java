package structures;

import java.util.List;

public class BinaryTreeNode {
	public int val;
	public Object data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int x){
		val=x;
		left=null;
		right=null;
	}
	
	public BinaryTreeNode(int x, Object input){
		val=x;
		left=null;
		right=null;
		data=input;
	}
	
	public BinaryTreeNode(int index, Object input, int size, List<Object> others){ // ?
		val=index;
		left=null;
		right=null;
		if (size == 0) {
			return;
		}else if (size == 1) {
			return;
		}else if (size == 2) {// ?
			left= new BinaryTreeNode(index, input); //others 0 ?
			return;
		}
		data=input;
		return;
	}
}
