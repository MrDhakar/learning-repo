package algo.java.linkedlist;

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