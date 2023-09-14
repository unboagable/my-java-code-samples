package structures;

public class LocalQueue {
	LinkedListNode first, last;
	void enqueue(int item){
		if (first == null){
			last = new LinkedListNode(item);
			first=last;
		}else{
			last.setNext(new LinkedListNode(item));
			last=last.next;
		}
	}
	
	LinkedListNode dequeue(LinkedListNode n){
		if (first != null){
			LinkedListNode item=first;
			first = first.getNext();
			return item;
		}
		return null;
	}
}
