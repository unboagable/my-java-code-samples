package solutions;

import structures.LinkedListNode;

public class LinkedList {
	
	//ctci:P2.1
	public static LinkedListNode removeDuplicates(LinkedListNode head){
		LinkedListNode n = head;
		int ndata;
		while (n.next != null) {
			ndata=n.data;
			n.next=LinkedListNode.deleteNode(n.next,ndata);
			n = n.next;
			if (n == null){return head;}
		}
		return head;
	}
	
	//ctci:P2.2
	public static LinkedListNode findNthLastElement(LinkedListNode head, int nth){
		LinkedListNode n = head;
		int nf=0;
		while (n.next != null) {
			n = n.next;
			nf++;
		}
		
		nth=nf-nth;
		if (nth <= 0){return head;}
		n = head;
		for (int i=0; i<nth; i++) {
			n = n.next;
		}
		return n;
	}
	
	//ctci:P2.3
	public static void deleteMiddleNode(LinkedListNode middle){
		LinkedListNode next=middle.next;
		middle.data=next.data;
		middle.next =next.next;
	}
	
	//ctci:P2.4
	public static LinkedListNode addLL(LinkedListNode left, LinkedListNode right){
		if (left == null){ return right;}
		else if (right == null){return left;}
		else{
			LinkedListNode cleft=left.next;
			LinkedListNode cright=right.next;
			int resultdata = left.data + right.data;
			LinkedListNode result=new LinkedListNode(resultdata % 10);
			LinkedListNode cresult=result;
			resultdata /= 10;
			while (cleft != null && cright != null){
				resultdata+=cleft.data+cright.data;
				cresult.appendToTail(resultdata%10);
				cresult=cresult.next;
				cleft=cleft.next;
				cright=cright.next;
				resultdata /=10;
			}
			if (cleft != null){
				while (cleft != null){
					resultdata+=cleft.data;
					cresult.appendToTail(resultdata%10);
					cresult=cresult.next;
					cleft=cleft.next;
					resultdata /=10;
				}
			}else if (cright != null){
				while (cright != null){
					resultdata+=cright.data;
					cresult.appendToTail(resultdata%10);
					cresult=cresult.next;
					cright=cright.next;
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
