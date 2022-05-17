package learningLogic.Tree;

public class BinaryTreeLinkedListMain {

	public static void main(String[] args) {
		BinaryTreeLinkedList bt = new BinaryTreeLinkedList();
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		System.out.println("________________");
		bt.inorder(bt.root);
	}

}
