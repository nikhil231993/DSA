package learningLogic.Tree;

public class BinaryTreeRevisionMain {

	public static void main(String[] args) {

		BinaryTreeRevision bt = new BinaryTreeRevision();
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		System.out.println("In order traversal data is : ");
		bt.inOrderTraversal(bt.root);
		System.out.println("\nPre order traversal data is : ");
		bt.preOrderTraversal(bt.root);
		System.out.println("\nPost order traversal data is : ");
		bt.postorderTraversal(bt.root);
		System.out.println("\nLevel order traversal data is : ");
		bt.levelOrderTraversal(bt.root);
		System.out.println("\nSearching value in Tree:");
		System.out.println("\nUsing inorder traversal");
		bt.inDepthFirstSearch(bt.root,20);
	}

}
