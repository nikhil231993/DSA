package leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class V52LC99RecoverBSTMain {

	public static void main(String[] args) {

		//Brute force:
		//1.Do any traversal and sort it
		//2.Simply  do inorder and if the values are incorrect change it
		//TC:O(2n)+O(nlog n)
		//SC:O(n)

		BinarySearchTree bst = new BinarySearchTree();

		Node root=new Node(3);
		root.left=new Node(1);
		root.right=new Node(4);
		root.right.left=new Node(2);

		System.out.println("Inorder traversal");
		List<Integer> list=new ArrayList();
		bst.inorderRecoverBST(root,list);
		System.out.println(list);

		//Recover BST
		bst.recover(root);

		System.out.println("Inorder traversal after recovering");
		List<Integer> listRec=new ArrayList();
		bst.inorderRecoverBST(root,listRec);
		System.out.println(listRec);
	}
}
