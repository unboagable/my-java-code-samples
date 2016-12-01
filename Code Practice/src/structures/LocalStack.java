package structures;

public class LocalStack {
	LLNode top;
	
	public LocalStack() {}
	
	LLNode pop(){
		if (top != null){
			LLNode item=top;
			top=top.getNext();
			return item;
		}
		return null;
	}
	
	void push(int item){
		LLNode t = new LLNode(item);
		t.next = top;
		top=t;
	}
}
