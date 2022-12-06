
/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    //Your code goes here
		if (k == 0) {
			System.out.println(root.data);
			return;
		}

		nodesAtDistanceKHelper_1(root, node, k);
	}
	
	private static int nodesAtDistanceKHelper_1(BinaryTreeNode<Integer> root, int node, int k) {
		if (root == null) return -1;
		if (root.data == node) {
			nodesAtDistanceKHelper_2(root.left, k - 1);
			nodesAtDistanceKHelper_2(root.right, k - 1);
			return 1;
		}
		
		int ll = nodesAtDistanceKHelper_1(root.left, node, k);
		int rr = nodesAtDistanceKHelper_1(root.right, node, k);
		
		if (ll != -1) {
			if (ll == k) {
				System.out.println(root.data);
			} else if (ll < k) {
				nodesAtDistanceKHelper_2(root.right, k - ll - 1);
			}
			return ++ll;
		}
		
		if (rr != -1) {
			if (rr == k) {
				System.out.println(root.data);
			} else if (rr < k) {
				nodesAtDistanceKHelper_2(root.left, k - rr - 1);
			}
			return ++rr;
		}
		
		return -1;
	}
	
	private static void nodesAtDistanceKHelper_2(BinaryTreeNode<Integer> root, int k) {
		if (root == null) return;
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		nodesAtDistanceKHelper_2(root.left, k - 1);
		nodesAtDistanceKHelper_2(root.right, k - 1);
	}

}