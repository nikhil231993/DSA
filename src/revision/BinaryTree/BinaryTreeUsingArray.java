package revision.BinaryTree;

public class BinaryTreeUsingArray {
	
	int[] arr;
	int lastUsedIndex = 0;

	public BinaryTreeUsingArray(int size) {
		arr = new int[size + 1];
	}

	public void insert(int value) {

		if (isTreeFull()) {
			System.out.println("Tree is full so cannot insert an element");
			return;
		}
		arr[++lastUsedIndex] = value;

	}

	private boolean isTreeFull() {
		if (lastUsedIndex == arr.length)
			return true;
		return false;
	}

	public void levelOrder() {
		for (int i = 1; i <= lastUsedIndex; i++)
			System.out.print(arr[i] + "-->");

	}

	public void preOrder(int root) {
		if (root <= lastUsedIndex) {
			System.out.print(arr[root] + "-->");
			preOrder(root * 2);
			preOrder(root * 2 + 1);
		}

	}

	public void postOrder(int root) {
		if (root <= lastUsedIndex) {

			postOrder(root * 2);
			postOrder(root * 2 + 1);
			System.out.print(arr[root] + "-->");
		}

	}

	public void inOrder(int root) {
		if (root <= lastUsedIndex) {

			inOrder(root * 2);
			System.out.print(arr[root] + "-->");
			inOrder(root * 2 + 1);

		}

	}

	public void search(int value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.println("Value found at pos: " + i);
				return;
			}
		}

	}

	public void delete(int value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.println("Replacing " + value + " with " + arr[lastUsedIndex]);
				arr[i] = arr[lastUsedIndex];
				lastUsedIndex--;
				return;
			}
		}

	}

	public void deleteTree() {
		arr = null;

	}
}
