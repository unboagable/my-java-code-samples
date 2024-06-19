package structures;

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
}
