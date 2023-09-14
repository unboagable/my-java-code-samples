package structures;

public class LocalStack {
	LinkedListNode top;
	
	public LocalStack() {}
	
	LinkedListNode pop(){
		if (top != null){
			LinkedListNode item=top;
			top=top.getNext();
			return item;
		}
		return null;
	}
	
	void push(int item){
		LinkedListNode t = new LinkedListNode(item);
		t.next = top;
		top=t;
	}
}
