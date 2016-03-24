package structures;

public class LocalStack {
	Node top;
	
	public LocalStack() {}
	
	Node pop(){
		if (top != null){
			Node item=top;
			top=top.getNext();
			return item;
		}
		return null;
	}
	
	void push(int item){
		Node t = new Node(item);
		t.next = top;
		top=t;
	}
}
