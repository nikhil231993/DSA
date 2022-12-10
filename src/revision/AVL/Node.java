package revision.AVL;

public class Node {

	Node left;
	Node right;
	int key;
	int height;

	Node(int key) {
		this.key = key;
		this.height = 0;
		this.left = this.right = null;
	}

}
