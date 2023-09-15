package structures;

//Linked list node
public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	
	public LinkedListNode(int d) { data = d; }
	
	public static LinkedListNode linkedListFromArray(int[] da) {
		if (da == null || da.length == 0) {
			return null;
		}
		
		LinkedListNode head = new LinkedListNode(da[0]);
		LinkedListNode n=head;
		for(int i=1; i < da.length;i++){
			n.next=new LinkedListNode(da[i]);
			n=n.next;
		}
		return head;
	}
	
	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}
	
	public static LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode n = head;
		if (n.data == d) {
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				System.out.println(d);
			}
			n = n.next;
		}
		return head; /* head didn't change */
	}
	
	public void printLinkedList(){
		System.out.print("LL: ");
		System.out.print(this.data);
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
			System.out.print("->");
			System.out.print(n.data);
		}
		System.out.println("->END");
	}
	
	public int getData(){
		return this.data;
	}

	public void setData(int data2) {
		this.data=data2;
	}

	public LinkedListNode getNext() {
		return this.next;
	}

	public void setNext(LinkedListNode next2) {
		this.next=next2;
	}
}
