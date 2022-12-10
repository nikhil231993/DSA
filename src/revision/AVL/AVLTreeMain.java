package revision.AVL;

public class AVLTreeMain {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		Node root = null;
		/* Constructing tree given in the above figure */
		root = tree.insert(root, 10);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		root = tree.insert(root, 20);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		root = tree.insert(root, 30);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		root = tree.insert(root, 40);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		root = tree.insert(root, 50);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		root = tree.insert(root, 25);

		/*
		 * The constructed AVL Tree would be
		 * 
		 * 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println();
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(root);
		System.out.println();
		System.out.println("Level order traversal" + " of constructed tree is : ");
		tree.levelOrderTraversal(root);
		System.out.println();
		System.out.println("Searching a value in a tree : ");
		tree.breadthFirstSearch(root, 50);
		tree.deleteNode(root, 30);
		System.out.println("Level order traversal" + " of constructed tree after deletetion is : ");
		tree.levelOrderTraversal(root);

	}

}
