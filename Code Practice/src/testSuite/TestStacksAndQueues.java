package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import structures.MyQueue;

public class TestStacksAndQueues {

	@Test
	public void testMyQueue() {
		MyQueue q1=new MyQueue();
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		q1.enqueue(4);
		assertEquals("Queue 1-2-3-4 first pop 1", 1, q1.dequeue());
	}

}
