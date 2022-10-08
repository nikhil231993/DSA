package learningLogic.AVL;

public class AVLTreeMain {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.root = tree.insert(tree.root, 20);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.root = tree.insert(tree.root, 30);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.root = tree.insert(tree.root, 40);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.root = tree.insert(tree.root, 50);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.root = tree.insert(tree.root, 25);

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println();
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);

	}

}
