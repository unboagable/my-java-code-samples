package solutions;

import structures.LLNode;

public class LinkedList {
	
	//ctci:P2.1
	public static LLNode removeDuplicates(LLNode head){
		LLNode n = head;
		int ndata;
		while (n.getNext() != null) {
			ndata=n.getData();
			n.setNext(LLNode.deleteNode(n.getNext(),ndata));
			n = n.getNext();
			if (n == null){return head;}
		}
		return head;
	}

	
	//ctci:P2.2
	public static LLNode findNthLastElement(LLNode head, int nth){
		LLNode n = head;
		int nf=0;
		while (n.getNext() != null) {
			n = n.getNext();
			nf++;
		}
		
		nth=nf-nth;
		if (nth <= 0){return head;}
		n = head;
		for (int i=0; i<nth; i++) {
			n = n.getNext();
		}
		return n;
	}
	
	//ctci:P2.3
	public static void deleteMiddleNode(LLNode middle){
		LLNode next=middle.getNext();
		middle.setData(next.getData());
		middle.setNext(next.getNext());
	}
	
	//ctci:P2.4
	public static LLNode addLL(LLNode left, LLNode right){
		if (left == null){ return right;}
		else if (right == null){return left;}
		else{
			LLNode cleft=left.getNext();
			LLNode cright=right.getNext();
			int resultdata = left.getData() + right.getData();
			LLNode result=new LLNode(resultdata % 10);
			LLNode cresult=result;
			resultdata /= 10;
			while (cleft != null && cright != null){
				resultdata+=cleft.getData()+cright.getData();
				cresult.appendToTail(resultdata%10);
				cresult=cresult.getNext();
				cleft=cleft.getNext();
				cright=cright.getNext();
				resultdata /=10;
			}
			if (cleft != null){
				while (cleft != null){
					resultdata+=cleft.getData();
					cresult.appendToTail(resultdata%10);
					cresult=cresult.getNext();
					cleft=cleft.getNext();
					resultdata /=10;
				}
			}else if (cright != null){
				while (cright != null){
					resultdata+=cright.getData();
					cresult.appendToTail(resultdata%10);
					cresult=cresult.getNext();
					cright=cright.getNext();
					resultdata /=10;
				}
			}
			if (resultdata != 0){
				cresult.appendToTail(resultdata%10);
			}
			return result;

		}
	}
}
