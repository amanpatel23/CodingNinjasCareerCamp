public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */

	static class Pair {
		LinkedListNode<Integer> ff;
		LinkedListNode<Integer> ss;
		Pair(LinkedListNode<Integer> ff, LinkedListNode<Integer> ss) {
			this.ff = ff;
			this.ss = ss;
		}
	}
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

		return constructLinkedListHelper(root).ff;
	}
	
	private static Pair constructLinkedListHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new Pair(null, null);
		}
		
		Pair rr = constructLinkedListHelper(root.right);
		Pair ll = constructLinkedListHelper(root.left);
		
		LinkedListNode<Integer> tail = ll.ss;
		LinkedListNode<Integer> head = rr.ff;
		LinkedListNode<Integer> nNode = new LinkedListNode<>(root.data);		
		
		if (tail == null && head == null) {
			return new Pair(nNode, nNode);
		} else if (tail == null) {
			nNode.next = head;
			return new Pair(nNode, rr.ss);
		} else if (head == null) {
			tail.next = nNode;
			return new Pair(ll.ff, nNode);
		} else {
			tail.next = nNode;
			nNode.next = head;
			return new Pair(ll.ff, rr.ss);
		}
	}
}