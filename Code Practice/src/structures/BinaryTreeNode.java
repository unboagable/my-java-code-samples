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
	
	public BinaryTreeNode BinaryTreeNode(int x, Object input, int size, List<Object> others){
		val=x;
		if (size == 0) {
			return null;
		}else if (size == 1) {
			return new BinaryTreeNode(x, input);
		}
		left=null;
		right=null;
		data=input;
		return null;
	}
}
