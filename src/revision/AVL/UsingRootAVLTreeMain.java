package revision.AVL;

public class UsingRootAVLTreeMain {

	public static void main(String[] args) {
		UsingRootAVLTree tree = new UsingRootAVLTree();

		/* Constructing tree given in the above figure */
		tree.insertValue(10);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.insertValue(20);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.insertValue(30);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.insertValue(40);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.insertValue(50);
		System.out.println();
		System.out.println("preOrder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		tree.insertValue(25);

		/*
		 * The constructed AVL Tree would be
		 * 
		 * 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println();
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("Level order traversal" + " of constructed tree is : ");
		tree.levelOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Searching a value in a tree : ");
		tree.breadthFirstSearch(tree.root, 50);
		tree.deleteNode(tree.root, 30);
		System.out.println("Level order traversal" + " of constructed tree after deletetion is : ");
		tree.levelOrderTraversal(tree.root);

	}

}
