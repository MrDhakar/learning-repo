package algo.java;

public class StackOps {

	private static final int STACK_SIZE = 5;
	private static int stack_count;
	private static LinkedListNode stack;
	public static void main(String[] args) {
		

		StackOps stackOps = new StackOps();
		stack=stackOps.push(stack, 5);
		stack=stackOps.push(stack, 6);
		stack=stackOps.push(stack, 3);
		stack=stackOps.push(stack, 4);
		stack=stackOps.push(stack, 9);
		
		System.out.println("peek : "+  stackOps.peek(stack));
		stackOps.display(stack);
		System.out.println();
		
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		
		System.out.println("peek : "+  stackOps.peek(stack));
		stackOps.display(stack);
		System.out.println();
		
		stack=stackOps.push(stack, 10);
		stack=stackOps.push(stack, 15);
		stack=stackOps.push(stack, 6);
		stack=stackOps.push(stack, 7);
		
		System.out.println("peek : "+  stackOps.peek(stack));
		stackOps.display(stack);
		System.out.println();
		
		
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		
		stackOps.display(stack);
		System.out.println();
		
		stack=stackOps.pop(stack);
		
		stackOps.display(stack);
		System.out.println();
		
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		stack=stackOps.pop(stack);
		
		System.out.println("peek : "+  stackOps.peek(stack));
		stackOps.display(stack);
		System.out.println();
	}

	LinkedListNode push(LinkedListNode stack, int num) {
		if (stack == null) {
			stack = new LinkedListNode(num);
			stack_count++;
		}else if (stack_count >= STACK_SIZE) {
			System.out.println("stack capacity is full");
		} else if (stack_count < STACK_SIZE) {
			LinkedListNode temp = new LinkedListNode(num);
			temp.next = stack;
			stack = temp;
			stack_count++;
		}

		return stack;

	}

	LinkedListNode pop(LinkedListNode stack) {
		if (stack == null) {
			System.out.println("stack is empty");
			return stack;
		}

		stack = stack.next;
		stack_count--;

		return stack;

	}
	
	int peek(LinkedListNode stack) {
		if (stack == null) {
			System.out.println("There is no peek");
			return -1;
		}
		return stack.num;
		
	}
	
	void display(LinkedListNode stack) {
		
		if (stack == null) System.out.println("No element in the stack");
		
		if (stack != null) {
			System.out.print(stack.num);	
		}
		if(stack!=null && stack.next!=null) {
			System.out.print("->");
			display(stack.next);
		}
		
	}
}
