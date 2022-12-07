public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */


	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

		if (root == null) return -1;
		
		if (root.data == a) return a;
		if (root.data == b) return b;
		
		if (Math.min(a, b) > root.data) {
			return getLCA(root.right, a, b);
		}else if (Math.max(a, b) < root.data) {
			return getLCA(root.left, a, b);
		}else {
			int ff = getLCA(root.left, a, b);
			int ss = getLCA(root.right, a, b);
			if (ff == -1) return ss;
			if (ss == -1) return ff;
			return root.data;
		}
	}
}