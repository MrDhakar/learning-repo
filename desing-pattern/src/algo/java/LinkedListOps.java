package algo.java;

public class LinkedListOps {
	public static void main(String[] args) {
		LinkedListNode list1 = new LinkedListNode(5);
		LinkedListNode list2 = new LinkedListNode(11);

		list1.insert(list1, 6);
		list1.insert(list1, 4);
		list1.insert(list1, 2);
		list1.insert(list1, 1);
		list1.insert(list1, 3);
		list1.insert(list1, 8);
		list1.insert(list1, 6);
		list1.insert(list1, 5);
		list1.insert(list1, 7);
		list1.insert(list1, 15);
		list1.insert(list1, 12);

		list2.insert(list2, 14);
		list2.insert(list2, 13);
		list2.insert(list2, 19);
		list2.insert(list2, 17);
		list2.insert(list2, 20);
		list2.insert(list2, 16);
		list2.insert(list2, 18);
		list2.next.next.next.next.next.next.next.next = list2.next.next.next;
		System.out.println(list2.next.next.next.num);
		/*
		 * System.out.println("Node num from 2 : " + list2.next.next.next.num);
		 * System.out.println("Node num from 1 : " +
		 * list1.next.next.next.next.next.num);
		 */
		/*
		 * list2.insert(list2, 22); list2.insert(list2, 21); list2.insert(list2, 23);
		 */

		/*
		 * list1.traverse(list2); list1.traverse(list1);
		 * System.out.println("size of list :" + list1.size(list2)); list1.delete(list2,
		 * 17); System.out.println("size of list :" + list1.size(list2));
		 * list1.traverse(list2); System.out.println(list1.search(list2, 17));
		 * System.out.println(list1.search(list2, 18)); list2 = list1.reverse(list2);
		 * list1.traverse(list2);
		 * System.out.println("size of list :"+list1.size(list2));
		 * System.out.println("intersection node: " + list1.intersection(list1,
		 * list2).num); list1.delete(list2, 12); list1.delete(list1, 12);
		 * System.out.println("mid node from 1 : " + list1.findMidElement(list1).num);
		 * System.out.println("mid node from 2: " + list1.findMidElement(list2).num);
		 * System.out.println("last kth node : " + list1.getLastkthNode(list2,8).num);
		 */

		System.out.println("Is Circular list 1: " + list1.checkCircularList(list1));
		System.out.println("Is Circular list 2: " + list1.checkCircularList(list2).num);
	}

}

class LinkedListNode {

	Integer num;
	LinkedListNode next;

	LinkedListNode(int num) {
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
