package leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinarySearchTree {

	public Node insert(Node root, int value) {

		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (root.data > value) {
			root.left = insert(root.left, value);
		} else if (root.data < value) {
			root.right = insert(root.right, value);
		}
		return root;
	}

	public void ceil(Node root, int[] ceil, int key) {

		if(root==null)
			return;
		if(root.data==key){
			ceil[0]=root.data;
			return;
		}
		if(root.data>key){
			ceil[0]= root.data;
			ceil(root.left,ceil,key);
		}else{
			ceil(root.right,ceil,key);
		}
	}

	public int ceilIterative(Node root, int key) {

		int ceil=-1;

		while(root!=null){
			if(root.data==key){
				ceil=root.data;
				return ceil;
			}

			if(key<root.data){
				ceil=root.data;
				root=root.left;
			}else{
				root=root.right;
			}
		}
		return ceil;

		//TC:O(logN) which is the height of the tree
		//SC:O(1) as it is iterative and no extra space is required
	}

	public int floorIterative(Node root, int key) {

		int floor=Integer.MAX_VALUE;

		while(root!=null){
			if(root.data==key)
			{
				floor= root.data;;
				return floor;
			}
			if(root.data>key){
				root=root.left;
			}else{
				floor=root.data;
				root=root.right;
			}
		}
		return floor;

		//TC:O(log n)
		//SC:O(1)
	}

	public int kthSmallestElement(Node root, int k) {

		if(root==null)
			return 0;
		int[] count=new int[1];
		int[] value=new int[1];
		kSmallest(root, k, count, value);
		return value[0];
	}

	private void kSmallest(Node root, int k, int[] count, int[] value) {

		if(root==null)
			return;
		kSmallest(root.left, k, count, value);
		count[0]++;
		if(count[0]==k){
			value[0]=root.data;
			return;
		}
		kSmallest(root.right,k ,count, value);

		//TC:O(N) as we have to parse each element
		//SC:O(N) stack space. This can be improved by using Morris Traversal
	}

	public int kthLargestElement(Node root, int k) {

		int[] count=new int[1];
		nodesCount(root,count);
		int largest=count[0]-k+1;

		int[] c=new int[1];
		int[] val=new int[1];
		kSmallest(root,largest,c,val);
		return val[0];
	}

	private void nodesCount(Node root, int[] count) {

		if(root==null)
			return;
		count[0]++;
		nodesCount(root.left,count);
		nodesCount(root.right,count);
	}

	public boolean validBST(Node root) {

		if(root==null)
			return true;
		return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	private boolean isValid(Node root, long minValue, long maxValue) {

		if(root==null)
			return true;
		if(root.data >=maxValue || root.data<=minValue )
			return false;
		return isValid(root.left, minValue, root.data) && isValid(root.right , root.data, maxValue);

		//TC:O(N)
		// SC:O(H)
	}


	public void inorder(Node root) {

		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "-->");
			inorder(root.right);
		}
	}

	public void preorder(Node root) {

		if (root != null) {
			System.out.print(root.data + "-->");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder(Node root) {

		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + "-->");
		}
	}

	public boolean search(Node root, int value) {

		if (root == null)
			return false;
		if (root.data == value)
			return true;
		else if (root.data < value)
			return search(root.right, value);
		else
			return search(root.left, value);
	}

	public Node delete(Node root, int value) {

		if (root == null)
			return null;
		if (root.data < value) {
			root.right = delete(root.right, value);
		} else if (root.data > value)
			root.left = delete(root.left, value);
		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			Node iS = inOrderSuccessor(root.right);
			root.data = iS.data;
			root.right = delete(root.right, iS.data);
		}
		return root;
	}

	private Node inOrderSuccessor(Node root) {

		while (root.left != null)
			root = root.left;
		return root;
	}

	public void printRange(Node root, int l, int u) {

		if(root==null)
			return;
		if(root.data >=l && root.data <=u) {
			System.out.print(root.data + "-->");
		}
			printRange(root.left, l, u);
			printRange(root.right, l, u);
	}

	private ArrayList<Integer> arr = new ArrayList<Integer>();

	public void rootToLeaf(Node root) {

		if (root == null)
			return;

		arr.add(root.data);
		if (root.left == null && root.right == null) {
			System.out.println("Leaf Path is :");
			print(arr);
		}
		rootToLeaf(root.left);
		rootToLeaf(root.right);

		arr.remove(arr.size() - 1);
	}

	private void print(ArrayList<Integer> arr) {

		for (Integer n : arr) {
			System.out.print(n + "-->");
		}
		System.out.println("Next Leaf is:  ");
	}

	public void levelorder(Node root) {

		if(root==null)
			return;
		else {
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				Node temp = q.peek();
				q.remove();
				System.out.print(temp.data + "-->");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

	public int maxDepth(Node root) {

		if (root == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public  int maxSumBST(Node root) {
		return largestBSTSubtreeHelper(root).maxSize;
	}

	private  NodeValue largestBSTSubtreeHelper(Node root) {

		// An empty tree is a BST of size 0.
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND smaller than min in right, it is a BST.
		if (left.maxNode < root.data && root.data < right.minNode) {
			// It is a BST.
			return new NodeValue(  Math.min(root.data, left.minNode),Math.max(root.data, right.maxNode),left.maxSize + right.maxSize + 1);
		}

		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
				Math.max(left.maxSize, right.maxSize));
	}

	public void inorderRecoverBST(Node root, List<Integer> list) {

		if(root==null)
			return;
		inorderRecoverBST(root.left,list);
		list.add(root.data);
		inorderRecoverBST(root.right,list);
	}

	//below elements are used to recover BST
	private Node first;
	private Node last;
	private Node middle;
	private Node prev;
	public void recover(Node root) {

		prev=new Node(Integer.MIN_VALUE);
		inorderRecover(root);

		if(first!=null && last!=null){
			int t=first.data;
			first.data=last.data;
			last.data=t;
		}else if(first!=null && middle!=null){
			int t=first.data;
			first.data=middle.data;
			middle.data=t;
		}
	}

	private void inorderRecover(Node root) {

		if(root==null)
			return;

		inorderRecover(root.left);
		if(prev!=null && root.data<prev.data){
			if(first==null){
				first=prev;
				middle=root;
			}else
				last=root;
		}
		prev=root;
		inorderRecover(root.right);
	}

	public int lcaBST(Node root, int p, int q) {

		if(root==null)
			return 0;

		if(root.data < p && root.data < q)
			return lcaBST(root.right, p, q);
		if(root.data > p && root.data > q)
			return lcaBST(root.left, p, q);

		return root.data;

		//TC:O(log N)
		//TC:O(H)
	}

	public int lowestCommonAncestor(Node root, int p, int q) {

		Node node=root;
		while(true){
			if(root==null)  return 0;
			if(node.data > p && node.data >q)
				node=node.left;
			else if(node.data<p && node.data<q)
				node=node.right;
			else return node.data;
		}
	}

	public int inorderSuccessorBST(Node root, int key) {

		if(root==null)
			return -1;
		int ceil=-1;
		while(root!=null){
			if(root.data>key){
				ceil=root.data;
				root=root.left;
			}else if(root.data<=key){
				root=root.right;
			}
		}
		return ceil;

		//TC:O(log n)
		//SC:o(1)
	}

	public int inorderPredecessorBST(Node root, int key) {

		if(root==null)
			return -1;
		int floor=-1;
		while(root!=null){
			if(root.data>=key)
				root=root.left;
			else{
				floor=root.data;
				root=root.right;
			}
		}
		return floor;

		//TC:O(log n)
		//SC:o(1)
	}

	public boolean twoSumBST(Node root, int k) {

		if(root==null)
			return false;

		//Create two stack using two instances of same class so virtually you are not creating two stack
		BSTIterator left=new BSTIterator(root,false);
		BSTIterator right=new BSTIterator(root,true);

		int small=left.next();
		int large=right.next();

		while(small<large){
			if(small+large==k)
				return true;
			else if(small+large>k)
			{
				large=right.next();
			}else{
				small=left.next();
			}
		}

		return false;

		//TC:O(N)
		//SC:O(H)*2 as we create two stack. In brute force we find inorder and then use two pointer technique so there space will be O(N)
	}

	public List<List<Integer>> pathSum(Node root, int targetSum) {

		if(root==null)
			return new ArrayList();
		List<List<Integer>> arr=new ArrayList();
		List<Integer> path=new ArrayList();
		path(arr, root, targetSum, path);
		return arr;
	}

	public static void path(List<List<Integer>> paths, Node root, int targetSum, List<Integer> path){

		if(root==null)
			return ;

		path.add(root.data);
		if(root.left==null && root.right==null && targetSum==root.data){
			paths.add(new ArrayList<Integer>(path));
			return;
		}
		path(paths, root.left, targetSum-root.data, path);
		path(paths, root.right, targetSum-root.data, path);
		path.remove(path.size()-1);

		//TC:o(n)
		// sc:o(logn)
	}

	public static boolean searchLevel(Node root, int value) {

		if(root==null) return false;
		if(root.data==value) return true;
		Queue<Node> q=new LinkedList();
		q.offer(root);

		while(!q.isEmpty()){
			Node node=q.poll();
			if(node.data==value)
				return true;
			else if(node.data<value && node.right!=null)
				q.offer(node.right);
			else if(node.data>value && node.left!=null)
				q.offer(node.left);
		}
		return false;

		//TC:O(logn)
		//SC:O(1)
	}

	public static int findCeilUsingQueue(Node root, int key) {

		if (root == null) return -1;
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		int value=-1;

		while(!q.isEmpty()){
			Node node=q.poll();
			if(node!=null && node.data>=key){
				value=node.data;
				q.offer(node.left);
			}else if(node!=null && node.data<key){
				q.offer(node.right);
			}
		}
		return value;

		//TC:O(logN) which is the height of the tree
		//SC:O(N) for queue
	}

	public Node insertIterative(Node root, int value) {

		Node node=new Node(value);
		if(root==null)
			return node;
		Node current=root;

		while(true){
			if(current.data>value){
				if(current.left==null){
					current.left=node;
					break;
				}else{
					current=current.left;
				}
			}else{
				if(current.right==null){
					current.right=node;
					break;
				}else{
					current=current.right;
				}
			}
		}
		return root;

		//TC:O(log N)
		//SC:O(1)
	}
}
