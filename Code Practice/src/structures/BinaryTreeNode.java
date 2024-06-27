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
			data = input;
			return;
		}else if (size == 2) {// 2 node tree
			left= new BinaryTreeNode(0, others.get(0));
			data = others.get(1);
			val=1;
			return;
		}else if (size == 3) {// 3 node tree
			left= new BinaryTreeNode(0, others.get(0));
			data = others.get(1);
			val=1;
			right= new BinaryTreeNode(2, others.get(2));
			return;
		}
		data=input;
		return;
	}
}
