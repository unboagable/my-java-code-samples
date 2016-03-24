package structures;

public class LocalQueue {
	Node first, last;
	void enqueue(int item){
		if (first == null){
			last = new Node(item);
			first=last;
		}else{
			last.setNext(new Node(item));
			last=last.next;
		}
	}
	
	Node dequeue(Node n){
		if (first != null){
			Node item=first;
			first = first.getNext();
			return item;
		}
		return null;
	}
}
