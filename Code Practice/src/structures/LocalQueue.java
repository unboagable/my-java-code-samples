package structures;

public class LocalQueue {
	LLNode first, last;
	void enqueue(int item){
		if (first == null){
			last = new LLNode(item);
			first=last;
		}else{
			last.setNext(new LLNode(item));
			last=last.next;
		}
	}
	
	LLNode dequeue(LLNode n){
		if (first != null){
			LLNode item=first;
			first = first.getNext();
			return item;
		}
		return null;
	}
}
