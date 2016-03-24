package structures;

import java.util.EmptyStackException;
import java.util.Stack;

//3.5 Implement a MyQueue class which implements a queue using two stacks.
public class MyQueue{
	Stack <Integer> enq;
	Stack <Integer> deq;
	boolean isEmpty;
	boolean isInEnq;

	public MyQueue(){
		enq=new Stack<Integer>();
		deq=new Stack<Integer>();
		isEmpty=true;
		isInEnq=true;
	}

	private void flip(){
		if (isEmpty){return;}
		Stack <Integer> to, from;
		if (!isInEnq){to=enq; from=deq;}
		else{to=deq; from=enq;}
		while(!from.isEmpty()){
			to.push(from.pop());
		}
		isInEnq=!isInEnq;
	}

	public void enqueue(int data){
		if (!isInEnq){flip();}
		enq.push(data);
		if (isEmpty){isEmpty=false;}
	}

	public int dequeue(){
		if (isEmpty){
			 EmptyStackException e = new EmptyStackException();
			throw e;
		}
		if (isInEnq){flip();}
		int returnV=deq.pop();
		if (deq.empty()){isEmpty=true;}
		return returnV;
	}

	public boolean empty(){return isEmpty;}
}
