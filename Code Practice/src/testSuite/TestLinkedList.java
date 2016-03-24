package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.LinkedList;
import structures.Node;

public class TestLinkedList {

	@Test
	public void testNode() {
		int[] lLIA={0,0,1,1,2,2,3,3,4,4,5};
		Node lL=Node.linkedListFromArray(lLIA);
		lL.printLinkedList();
	}
	
	@Test
	public void testremoveDuplicates() {
		int[] lLIA={0,0,1,1,2,2,3,3,4,4,5};
		Node lL=Node.linkedListFromArray(lLIA);
		//lL.printLinkedList();
		lL=LinkedList.removeDuplicates(lL);
		//lL.printLinkedList();
		int[] lLIA2={0,0,1,1,2,2,3,3,4,4,};
		Node lL2=Node.linkedListFromArray(lLIA2);
		//lL2.printLinkedList();
		lL2=LinkedList.removeDuplicates(lL2);
		//lL2.printLinkedList();
	}
	
	@Test
	public void testfindNthLastElement(){
		int[] lLIA={0,1,2,3,4,5};
		Node lL=Node.linkedListFromArray(lLIA);
		Node thirdlast = LinkedList.findNthLastElement(lL, 3);
		assertEquals("3rd last element is 2", 2, thirdlast.getData());
	}
	
	@Test
	public void testdeleteMiddleNode(){
		int[] lLIA={0,1,2,3,4,5};
		Node lL=Node.linkedListFromArray(lLIA);
		lL.printLinkedList();
		Node middle=lL.getNext();
		LinkedList.deleteMiddleNode(middle);
		lL.printLinkedList();;
	}
	
	@Test
	public void testAddLL(){
		System.out.println("p2.4");
		int[] lLIA={1,3,5};
		Node lL=Node.linkedListFromArray(lLIA);
		lL.printLinkedList();
		int[] lLIA2={2,5,5,9};
		Node lL2=Node.linkedListFromArray(lLIA2);
		lL2.printLinkedList();
		Node result=LinkedList.addLL(lL, lL2);
		result.printLinkedList();
	}

}
