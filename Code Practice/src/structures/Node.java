package structures;

//Linked list node
public class Node {
	Node next = null;
	int data;
	
	public Node(int d) { data = d; }
	
	public static Node linkedListFromArray(int[] da) {
		Node head = new Node(da[0]);
		Node n=head;
		for(int i=1; i < da.length;i++){
			n.next=new Node(da[i]);
			n=n.next;
		}
		return head;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}
	
	public static Node deleteNode(Node head, int d) {
		Node n = head;
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
		return head; /* head didn’t change */
	}
	
	public void printLinkedList(){
		System.out.print("LL: ");
		System.out.print(this.data);
		Node n = this;
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

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next2) {
		this.next=next2;
	}
}
