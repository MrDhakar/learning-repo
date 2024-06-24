package algo.java.linkedlist;

public class LinkedListNode {

	public Integer num;
	public LinkedListNode next;

	public LinkedListNode(int num) {
		this.num = num;
		this.next = null;
	}

	LinkedListNode insert(LinkedListNode node, int num) {

		if (node == null) {
			node = new LinkedListNode(num);
			return node;
		}
		node.next = insert(node.next, num);

		return node;

	}

	void traverse(LinkedListNode node) {
		while (node.next != null) {
			System.out.print(node.num + "->");
			node = node.next;
		}
		System.out.println(node.num);
	}

	int size(LinkedListNode node) {

		if (node == null)
			return 0;
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}

	LinkedListNode delete(LinkedListNode node, int num) {

		if (node == null)
			return null;

		LinkedListNode temp = node;
		if (temp.num != num)
			temp.next = delete(temp.next, num);
		if (temp.num == num) {
			temp = temp.next;
		}
		return temp;

	}

	boolean search(LinkedListNode node, int num) {

		while (node != null && node.num != num)
			node = node.next;

		if (node == null)
			return false;
		else
			return true;

	}

	LinkedListNode reverse(LinkedListNode node) {
		if (node == null)
			return node;

		LinkedListNode prev = null;
		LinkedListNode current = node;
		LinkedListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

	}

	LinkedListNode intersection(LinkedListNode list1, LinkedListNode list2) {

		int d1 = list1.size(list1);
		int d2 = list2.size(list2);
		int d = (d1 > d2) ? d1 - d2 : d2 - d1;

		if (d1 > d2) {
			while (d > 0 && list1 != null) {
				list1 = list1.next;
				d--;
			}
		} else {
			while (d > 0 && list2 != null) {
				list2 = list2.next;
				d--;
			}
		}

		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1;
	}

	LinkedListNode findMidElement(LinkedListNode node) {

		if (node == null)
			return node;

		LinkedListNode current = node;
		LinkedListNode forward = node.next;

		while (forward != null && forward.next != null) {
			current = current.next;
			forward = forward.next.next;
		}
		return current;

	}

	LinkedListNode getLastkthNode(LinkedListNode node, int k) {
		if (node == null)
			return node;

		LinkedListNode current = node;

		LinkedListNode forward = node;
		while (k > 0 && forward != null) {
			forward = forward.next;
			k--;
		}
		System.out.println("forward" + forward.num);
		while (forward != null) {
			current = current.next;
			forward = forward.next;
		}
		return current;
	}

	LinkedListNode checkCircularList(LinkedListNode node) {
		LinkedListNode current = node;
		LinkedListNode forward = node.next;
		while (current != null && forward != null && forward.next != null && current != forward) {
			current = current.next;
			forward = forward.next.next;
		}
		if (current != null && forward != null && current == forward) {
			System.out.println("first meeting  point "+ current.num);
			current = node;
			while(current !=forward) {
				current= current.next;
				forward = forward.next;
			}
			return current;
		}
		
		return null;

	}

}
