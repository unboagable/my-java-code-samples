package structures;

//Linked list node
public class LLNode {
	LLNode next = null;
	int data;
	
	public LLNode(int d) { data = d; }
	
	public static LLNode linkedListFromArray(int[] da) {
		LLNode head = new LLNode(da[0]);
		LLNode n=head;
		for(int i=1; i < da.length;i++){
			n.next=new LLNode(da[i]);
			n=n.next;
		}
		return head;
	}
	
	public void appendToTail(int d) {
		LLNode end = new LLNode(d);
		LLNode n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}
	
	public static LLNode deleteNode(LLNode head, int d) {
		LLNode n = head;
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
		return head; /* head didn�t change */
	}
	
	public void printLinkedList(){
		System.out.print("LL: ");
		System.out.print(this.data);
		LLNode n = this;
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

	public LLNode getNext() {
		return this.next;
	}

	public void setNext(LLNode next2) {
		this.next=next2;
	}
}
