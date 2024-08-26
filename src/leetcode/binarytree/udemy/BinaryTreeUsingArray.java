package leetcode.binarytree.udemy;

public class BinaryTreeUsingArray {
	
	protected int[] arr;
	protected int lastUsedIndex = 0;

	public BinaryTreeUsingArray(int size) {
		this.arr = new int[size + 1];
	}

	public void insert(int value) {

		if (isTreeFull()) {
			System.out.println("Tree is full so cannot insert an element");
			return;
		}
		this.arr[++this.lastUsedIndex] = value;
	}

	private boolean isTreeFull() {

		if (this.lastUsedIndex == this.arr.length)
			return true;
		return false;
	}

	public void levelOrder() {

		for (int i = 1; i <= this.lastUsedIndex; i++)
			System.out.print(arr[i] + "-->");
	}

	public void preOrder(int root) {

		if (root <= this.lastUsedIndex) {
			System.out.print(this.arr[root] + "-->");
			preOrder(root * 2);
			preOrder(root * 2 + 1);
		}
	}

	public void postOrder(int root) {

		if (root <= this.lastUsedIndex) {
			postOrder(root * 2);
			postOrder(root * 2 + 1);
			System.out.print(this.arr[root] + "-->");
		}
	}

	public void inOrder(int root) {

		if (root <= this.lastUsedIndex) {
			inOrder(root * 2);
			System.out.print(this.arr[root] + "-->");
			inOrder(root * 2 + 1);
		}
	}

	public void search(int value) {

		for (int i = 1; i <= this.lastUsedIndex; i++) {
			if (this.arr[i] == value) {
				System.out.println("Value found at pos: " + i);
				return;
			}
		}
	}

	public void delete(int value) {

		for (int i = 1; i <= this.lastUsedIndex; i++) {
			if (this.arr[i] == value) {
				System.out.println("Replacing " + value + " with " + this.arr[this.lastUsedIndex]);
				this.arr[i] = this.arr[this.lastUsedIndex];
				this.lastUsedIndex--;
				return;
			}
		}
	}

	public void deleteTree() {

		this.arr = null;
	}
}
