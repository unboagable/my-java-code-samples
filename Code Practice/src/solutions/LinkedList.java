package solutions;

import structures.LinkedListNode;

public class LinkedList {
	
	//ctci:P2.1
	public static LinkedListNode removeDuplicates(LinkedListNode head){
		LinkedListNode n = head;
		int ndata;
		while (n.getNext() != null) {
			ndata=n.getData();
			n.setNext(LinkedListNode.deleteNode(n.getNext(),ndata));
			n = n.getNext();
			if (n == null){return head;}
		}
		return head;
	}
	
	//ctci:P2.2
	public static LinkedListNode findNthLastElement(LinkedListNode head, int nth){
		LinkedListNode n = head;
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
	public static void deleteMiddleNode(LinkedListNode middle){
		LinkedListNode next=middle.getNext();
		middle.setData(next.getData());
		middle.setNext(next.getNext());
	}
	
	//ctci:P2.4
	public static LinkedListNode addLL(LinkedListNode left, LinkedListNode right){
		if (left == null){ return right;}
		else if (right == null){return left;}
		else{
			LinkedListNode cleft=left.getNext();
			LinkedListNode cright=right.getNext();
			int resultdata = left.getData() + right.getData();
			LinkedListNode result=new LinkedListNode(resultdata % 10);
			LinkedListNode cresult=result;
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
