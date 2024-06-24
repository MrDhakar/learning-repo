package algo.java.queue;

import algo.java.linkedlist.LinkedListNode;

public class QueueOps {

	private static final int QUEUE_SIZE = 5;
	private static int queue_count;
	private static LinkedListNode queue;
	public static void main(String[] args) {
		

		QueueOps queueOps = new QueueOps();
		queue=queueOps.push(queue, 5);
		queue=queueOps.push(queue, 6);
		queue=queueOps.push(queue, 3);
		queue=queueOps.push(queue, 4);
		queue=queueOps.push(queue, 9);
		
		System.out.println("peek : "+  queueOps.peek(queue));
		queueOps.display(queue);
		System.out.println();
		
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		
		System.out.println("peek : "+  queueOps.peek(queue));
		queueOps.display(queue);
		System.out.println();
		
		queue=queueOps.push(queue, 10);
		queue=queueOps.push(queue, 15);
		queue=queueOps.push(queue, 6);
		queue=queueOps.push(queue, 7);
		
		System.out.println("peek : "+  queueOps.peek(queue));
		queueOps.display(queue);
		System.out.println();
		
		
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		
		queueOps.display(queue);
		System.out.println();
		
		queue=queueOps.pop(queue);
		
		queueOps.display(queue);
		System.out.println();
		
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		queue=queueOps.pop(queue);
		
		System.out.println("peek : "+  queueOps.peek(queue));
		queueOps.display(queue);
		System.out.println();
	}

	LinkedListNode push(LinkedListNode queue, int num) {
		if (queue == null) {
			queue = new LinkedListNode(num);
			queue_count++;
		}else if (queue_count >= QUEUE_SIZE) {
			System.out.println("queue capacity is full");
		} else if (queue_count < QUEUE_SIZE) {
 			int i=0;
 			LinkedListNode temp = queue;
			while(i<queue_count && temp.next!=null) {
				temp = temp.next;
				i++;
 			}
			temp.next = new LinkedListNode(num);;
			queue_count++;
		}
		return queue;

	}

	LinkedListNode pop(LinkedListNode queue) {
		if (queue == null) {
			System.out.println("queue is empty");
			return queue;
		}

		queue = queue.next;
		queue_count--;
		
		return queue;

	}
	
	int peek(LinkedListNode queue) {
		if (queue == null) {
			System.out.println("There is no peek");
			return -1;
		}
		return queue.num;
		
	}
	
	void display(LinkedListNode queue) {
		
		if (queue == null) System.out.println("No element in the queue");
		if (queue != null) {
			System.out.print(queue.num);	
		}
		if(queue!=null && queue.next!=null) {
			System.out.print("->");
			display(queue.next);
		}
		
	}
}
