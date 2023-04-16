package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeUsingLinkedList {

	Node root;

	public void insert(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.remove();
			
			if (temp.left == null) {
				temp.left = node;
				return;
			} else {
				queue.add(temp.left);
			}
			
			if(temp.right==null) {
				temp.right = node;
				return;
			}else {
				queue.add(temp.right);
			}
		}
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			inOrderTraversal(root.left);
			System.out.print(root.data + "-->");
			inOrderTraversal(root.right);
		}

	}

	public void preOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			System.out.print(root.data + "-->");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}

	}

	public void postorderTraversal(Node root) {
		if (root == null)
			return;
		else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + "-->");
		}

	}

	public void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node temp = queue.peek();
				queue.remove();
				System.out.print(temp.data + "-->");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);

			}
		}

	}

	private int pos = 0;
	public void inDepthFirstSearch(Node root, int data) {
		if (root == null) {
			return;
		} else {
			pos++;

			if (root.data == data) {
				System.out.println("value is found at: " + pos);
				return;
			}
			inDepthFirstSearch(root.left, data);
			inDepthFirstSearch(root.right, data);
		}

	}

	public void breadthFirstSearch(Node root, int data) {
		if (root == null) {
			return;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			int loc=0;
			while (!queue.isEmpty()) {
				loc++;
				Node temp = queue.peek();
				queue.remove();
				if(temp.data==data) {
					System.out.println("value is found at: " + loc);
					return;
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

	}

	public void deleteFromBinaryTree(Node root, int value) {

		if (root == null)
			return;
		else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {

				Node temp = queue.peek();
				queue.remove();
				if (temp.data == value) {
					Node deep = deepestNode();
					System.out.println();
					System.out.println("Deepest node is: " + deep.data);
					temp.data = deep.data;
					deleteDeepestNode(root);

				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

	}

	private void deleteDeepestNode(Node root) {
		if(root==null) 
			return;
		else {
			Queue<Node> queue=new LinkedList<Node>();
			queue.add(root);
			Node previousNode=null;
			Node currentNode=null;
			while (!queue.isEmpty()) {
				previousNode = currentNode;
				currentNode = queue.peek();
				queue.remove();
				if(currentNode.left==null) {
					previousNode.right=null;
							return;
				}
				if (currentNode.right == null) {
					currentNode.left=null;
					return;
				}

				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
		

	}

	private Node deepestNode() {
		Node temp=null;
		if (root == null) {
			return null;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				temp = queue.peek();
				queue.remove();
				System.out.print(temp.data + "-->");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);

			}
		}
		return temp;
	}

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null)
			return new ArrayList<>();

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		List<List<Integer>> list = new ArrayList<>();

		while (!q.isEmpty()) {
			List<Integer> l = new ArrayList();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
				l.add(temp.data);
			}
			list.add(l);
			// TC:O(n) as we have to parse all elements
			// SC:O(n) as we havr to store all elements also we do not consider l list as
			// its small;

		}
		return list;

	}

	public void iterativePreOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			Node temp = st.pop();
			System.out.print(temp.data + "-->");
			if (temp.right != null)
				st.push(temp.right);
			if (temp.left != null)
				st.push(temp.left);

			// TC:O(N)
			// SC:O(N) which is stack space in case of tre having more right nodes refer
			// note

		}
	}

	public List<Integer> iterativeInOrder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		Node node = root;
		Stack<Node> st = new Stack<Node>();
		while (true) {
			if (node != null) {
				st.add(node);
				node = node.left;
			} else {
				if (st.isEmpty())
					break;
				node = st.pop();
				result.add(node.data);
				node = node.right;
			}
		}
		return result;

	}

	public List<Integer> iterativPostOrder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		if (root == null)
			return new ArrayList<Integer>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node node = s1.pop();
			s2.push(node);
			if (node.left != null)
				s1.push(node.left);
			if (node.right != null)
				s1.push(node.right);

		}

		while (!s2.isEmpty()) {
			result.add(s2.pop().data);
		}
		return result;

	}

	public List<Integer> iterativPostOrderUsing1Stack(Node root2) {
		Stack<Node> st = new Stack<Node>();
		List<Integer> arr = new ArrayList<Integer>();
		Node current = root;
		while (!st.isEmpty() || current != null) {
			if (current != null) {
				st.push(current);
				current = current.left;
			} else {
				Node temp = st.peek().right;
				if (temp == null) {
					temp = st.pop();
					arr.add(temp.data);
					while (!st.isEmpty() && temp == st.peek().right) {
						temp = st.pop();
						arr.add(temp.data);
					}
				} else {
					current = temp;
				}
			}
		}
		return arr;

		// TC:O(2N) because N times to insert all elements in case of a right only tree
		// and inside loop runs n times to print it
		// SC:O(N)
	}

	public List<List<Integer>> allTraversalsStack(Node root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> predOrder = new ArrayList<Integer>();
		List<Integer> inOrder = new ArrayList<Integer>();
		List<Integer> postOrder = new ArrayList<Integer>();

		Stack<NodeWithValue> st = new Stack();
		st.add(new NodeWithValue(root, 1));
		while (!st.isEmpty()) {
			NodeWithValue n = st.pop();
			if (n.num == 1) {

				predOrder.add(n.node.data);
				n.num++;
				st.push(n);
				if(n.node.left!=null) {
					st.push(new NodeWithValue(n.node.left, 1));
				}
			} else if (n.num == 2) {
				inOrder.add(n.node.data);
				n.num++;
				st.push(n);
				if (n.node.right != null) {
					st.push(new NodeWithValue(n.node.right, 1));
				}
				
			}else {
				postOrder.add(n.node.data);
			}

		}
		list.add(predOrder);
		list.add(inOrder);
		list.add(postOrder);
		return list;

		// TC:O(3N) as we are iterating for 3 times
		// SC:O(4N) where 3 list and 1 stack
	}

	public int maxDepthRecursive(Node root) {
		if (root == null)
			return 0;
		int leftLen = maxDepthRecursive(root.left);
		int rightLen = maxDepthRecursive(root.right);
		return 1 + Math.max(leftLen, rightLen);
		// TC:O(N) as we have to travel each node
		// SC:O(N) in case of skewed tree
	}

	public int maxDepthIterative(Node root2) {
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int len = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			len++;
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
		}
		return len;
	}

	public boolean isBalanced(Node root2) {

		int height = maxHeight(root);
		if (height == -1)
			return false;
		return true;
	}

	public static int maxHeight(Node root) {
		if (root == null)
			return 0;
		int leftHeight = maxHeight(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = maxHeight(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return 1 + Math.max(leftHeight, rightHeight);
		// TC:o(n) as we have to trvese each node
		// SC:o(n) in case of skewed tree auxiliary space will be this much
	}

	public int diameter(Node root) {
		int[] diameter = new int[1];
		findDiameter(diameter, root);
		return diameter[0];
	}

	public static int findDiameter(int[] diameter, Node root) {
		if (root == null)
			return 0;
		int left = findDiameter(diameter, root.left);
		int right = findDiameter(diameter, root.right);
		diameter[0] = Math.max(left + right, diameter[0]);
		return 1 + Math.max(left, right);
		// TC:O(N)
		// SC:O(N)
	}

	public int maxPath(Node root2) {
		int[] max = new int[1];
		maxPath(root, max);
		return max[0];
	}

	public static int maxPath(Node root, int[] max) {
		if (root == null)
			return 0;
		int left = Math.max(0, maxPath(root.left, max));
		int right = Math.max(0, maxPath(root.right, max));
		max[0] = Math.max(max[0], root.data + left + right);
		return root.data + Math.max(left, right);

	}

	public List<List<Integer>> zigZag(Node root) {
		List<List<Integer>> result = new ArrayList();
		Queue<Node> q = new LinkedList();
		if (root == null)
			return new ArrayList();
		q.add(root);
		ArrayList<Integer> arr = null;
		boolean leftToRight = false;
		while (!q.isEmpty()) {
			int size = q.size();
			arr = new ArrayList();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				int index = i;
				if (leftToRight)
					arr.add(0, node.data);
				else
					arr.add(node.data);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);

			}
			if (leftToRight)
				leftToRight = false;
			else
				leftToRight = true;
			result.add(arr);
		}

		return result;
		// TC:o(n)
		// SC:o(n)
	}

	public List<Integer> boundaryTraversal(Node root) {
		if (root == null)
			return new ArrayList();
		
		List<Integer> result=new ArrayList<Integer>();
		if (isLeaf(root) == false)
			result.add(root.data);
		leftBoundary(root,result);
		addLeaves(root, result);
		rightBoundary(root, result);
		
		return result;
	}

	private void rightBoundary(Node root2, List<Integer> result) {
		Node current = root.right;
		List<Integer> list = new ArrayList<Integer>();
		while (current != null) {
			if (isLeaf(current) == false) {
				list.add(current.data);
			}

			if (current.right != null)
				current = current.right;
			else
				current = current.left;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}

	}

	private void addLeaves(Node root, List<Integer> result) {
		if (isLeaf(root)) {
			result.add(root.data);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, result);
		if (root.right != null)
			addLeaves(root.right, result);

	}

	private boolean isLeaf(Node root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

	private void leftBoundary(Node root, List<Integer> result) {
		Node current = root.left;
		while (current != null) {
			if (isLeaf(current) == false) {
				result.add(current.data);
			}

			if (current.left != null)
				current = current.left;
			else
				current = current.right;
		}

	}

}
