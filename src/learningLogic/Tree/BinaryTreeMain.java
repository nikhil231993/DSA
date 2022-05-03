package learningLogic.Tree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		System.out.println("________________");
		bt.inorder(bt.root);
	}

}
