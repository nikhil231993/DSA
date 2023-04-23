package leetcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;


class Tuple {
	Node node;
	int vert;
	int hori;

	public Tuple(Node node, int vert) {
		this.node = node;
		this.vert = vert;
	}
	public Tuple(Node node, int vert, int hori) {
		this.node = node;
		this.vert = vert;
		this.hori = hori;
	}


}

class Pair {
	Node node;
	int num;

	public Pair(Node node, int num) {
		this.node = node;
		this.num = num;
	}
}

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

			// TC:O(N)
			// SC:O(H) in normal tree or O(N) in case of skewed tree
		}

	}

	public void preOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			System.out.print(root.data + "-->");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
			// TC:O(N)
			// SC:O(H) in normal tree or O(N) in case of skewed tree
		}

	}

	public void postorderTraversal(Node root) {
		if (root == null)
			return;
		else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + "-->");
			// TC:O(N)
			// SC:O(H) in normal tree or O(N) in case of skewed tree
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
			// SC:O(n) as we have to store all elements also we do not consider size of l
			// list as it's small

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
			// SC:O(N) which is stack space in case of tree having more right nodes refer
			// note or else it will be O(H)

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
		// TC:O(N)
		// SC:O(H) which is stack space but in case of skewed it will be O(N)

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

		// TC:O(N)
		// SC:O(2N) only considering stack

	}

	public List<Integer>  iterativPostOrderUsing1Stack(Node root2) {
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
		
		// TC:O(H)+O(N)+o(H) where H is the height of the tree which is equal to O(N)
		// SC:O(N) only about algo complexity

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

	public List<List<Integer>> verticalTraversal(Node root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
		Queue<Tuple> q=new LinkedList<Tuple>();
		//For root vert and hori are 0 taking it as centre
		q.add(new Tuple(root, 0, 0));
		
		while(!q.isEmpty()) {
			Tuple tuple=q.poll();
			Node node=tuple.node;
			int x=tuple.vert;
			int y=tuple.hori;
			
			if(!map.containsKey(x)) {
				map.put(x,new TreeMap<>());
			}
			
			if(!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<Integer>());
			}
			
			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1, y + 1));
			}
			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1, y + 1));
			}

			map.get(x).get(y).offer(node.data);
		}

		List<List<Integer>> list = new ArrayList();
		
		for(TreeMap<Integer, PriorityQueue<Integer>> h:map.values()) {
			List<Integer> l=new ArrayList<Integer>();
			for(PriorityQueue<Integer> nodes: h.values()) {
//				System.out.println(nodes.toString());
				while(!nodes.isEmpty()) {
					l.add(nodes.poll());
				}
			}
			list.add(l);
		}
		return list;
	}

	public List<Integer> topView(Node root) {
		Queue<Tuple> q = new LinkedList<Tuple>();
		List<Integer> arr = new ArrayList<Integer>();
		
		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Tuple(root, 0));
		
		while(!q.isEmpty()) {
			Tuple tuple=q.poll();
			
			Node node=tuple.node;
			int x=tuple.vert;
			
			if (map.get(x) == null) {
				map.put(x, node.data);
			}

			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1));
			}

			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1));
			}
		}

		arr.addAll(map.values());
		return arr;

		// TC:o(n) I feel it should be O(nlogn ) as it is treemap
		// SC:o(n)

		// we cannot use recursive traversal directly in this
	}

	public List<Integer> bottomView(Node root2) {
		Queue<Tuple> q = new LinkedList<Tuple>();
		List<Integer> arr = new ArrayList<Integer>();

		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Tuple(root, 0));

		while (!q.isEmpty()) {
			Tuple tuple = q.poll();

			Node node = tuple.node;
			int x = tuple.vert;

			map.put(x, node.data);


			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1));
			}

			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1));
			}
	}

		arr.addAll(map.values());
		return arr;

		// TC:o(n)
		// SC:o(n)
	}

	public List<Integer> rightViewBinaryTree(Node root) {

		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	private void rightView(Node root, List<Integer> result, int level) {
		if (root == null)
			return;

		if (result.size() == level)
			result.add(root.data);
		
		rightView(root.right, result, level + 1);
		rightView(root.left, result, level + 1);

	}

	public List<Integer> leftViewBinaryTree(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		leftView(root, result, 0);
		return result;
	}

	private void leftView(Node root, List<Integer> result, int level) {
		if (root == null)
			return;
		if (result.size() == level)
			result.add(root.data);
		leftView(root.left, result, level + 1);
		leftView(root.right, result, level + 1);
	}

	public boolean isSymmetric(Node root) {

		if (root == null)
			return true;
		return isSymmetry(root.left, root.right);

	}

	public static boolean isSymmetry(Node left, Node right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.data != right.data)
			return false;
		return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
		// SC:O(H) is o log n . In this case there is no skewed tree
		// TC:o(n)
	}

	public List<Integer> rootToNode(Node root,int value) {
		List<Integer> path = new ArrayList<Integer>();
		if (root == null)
			return path;
		rootPathToNode(path, root, value);
		return path;
	}

	private static boolean rootPathToNode(List<Integer> path, Node root, int value) {
		if(root==null)
			return false;
		path.add(root.data);

		if (root.data == value)
			return true;
		if (rootPathToNode(path, root.left, value))
			return true;
		if (rootPathToNode(path, root.right, value))
			return true;

		path.remove(path.size() - 1);
		return false;
	}

	public boolean pathSum(Node root, int sum) {
	if(root==null)
		return false;
		if (root.left == null && root.right == null && root.data == sum)
			return true;
		return pathSum(root.left, sum - root.data) || pathSum(root.right, sum - root.data);
	}

	public int maxWdithOfBinaryTree(Node root) {
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(root, 0));
		int max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int minid = q.peek().num;
			int first = 0;
			int last = 0;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.peek().node;
				int currid = q.peek().num - minid;
				if (i == 0)
					first = currid;
				if (i == size - 1)
					last = currid;
				
				if(node.left!=null)
					q.offer(new Pair(node.left, 2 * currid + 1));
				if (node.right != null)
					q.offer(new Pair(node.right, 2 * currid + 2));
				q.remove();
			}
			max = Math.max(max, last - first + 1);
		}
		return max;

	}

	public static void childrenSumProperty(Node root) {
		if(root==null)
			return;
		int childSum = 0;

		if (root.left != null)
			childSum += root.left.data;

		if (root.right != null)
			childSum += root.right.data;
		if (childSum >= root.data)
			root.data = childSum;
		else{
			if(root.left!=null)
				root.left.data=root.data;
			if(root.right!=null)
				root.right.data=root.data;
		}
		
		childrenSumProperty(root.left);
		childrenSumProperty(root.right);

		int total = 0;
		if (root.left != null)
			total += root.left.data;
		if (root.right != null)
			total += root.right.data;

		if (root.left != null || root.right != null)
			root.data = total;

		// TC:o(n)
		// SC:O(H) but in case of skewed tree it will be O(N)
	}

	public List<Integer> NodesAtKDistanceFromGivenNode(Node root, Node target, int k) {
	Map<Node, Node> parent=new HashMap();
		parentMapping(parent, root);
		
		Queue<Node> q = new LinkedList();
			q.offer(target);
			
			Map<Node, Boolean> visited=new HashMap();
		visited.put(target, true);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (count == k)
				break;
			count++;

			for (int i = 0; i < size; i++) {
				Node node = q.poll();

				if (node.left != null && visited.get(node.left) == null) {
					q.offer(node.left);
					visited.put(node.left, true);
				}
				
				if(node.right!=null && visited.get(node.right)==null) {
					q.offer(node.right);
					visited.put(node.right, true);
				}
				
				if (parent.get(node) != null && visited.get(parent.get(node)) == null) {
					q.offer(parent.get(node));
					visited.put(parent.get(node), true);
				}
			}
		}

	
		List<Integer> result = new ArrayList();
		while (!q.isEmpty())
			result.add(q.poll().data);
		return result;
		// TC:O(N)+O(N)
		// SC:O(N) parent+O(N) queue+o(N) visited
		
	}

	private static void parentMapping(Map<Node, Node> parent, Node root) {
		Queue<Node> q = new LinkedList();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();

				if (node.left != null) {
					q.offer(node.left);
					parent.put(node.left, node);
				}
				if (node.right != null) {
					q.offer(node.right);
					parent.put(node.right, node);
				}
			}

		}
		// TC:O(N)

	}

	public int burnTree(Node root, int start) {

		Map<Node, Node> parent = new HashMap();
		Node target = parentMapping(parent, root, start);

		Queue<Node> q = new LinkedList();
		q.offer(target);
		Map<Node, Boolean> visited = new HashMap();
		visited.put(target, true);
		int max = 0;
		while (!q.isEmpty()) {
			int flag = 0;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				if (node.left != null && visited.get(node.left) == null) {
					flag = 1;
					q.offer(node.left);
					visited.put(node.left, true);
				}

				if (node.right != null && visited.get(node.right) == null) {
					flag = 1;
					q.offer(node.right);
					visited.put(node.right, true);
				}

				if (parent.get(node) != null && visited.get(parent.get(node)) == null) {
					flag = 1;
					q.offer(parent.get(node));
					visited.put(parent.get(node), true);
				}
			}

			if (flag == 1) {
				max++;
			}
		}
		return max;
	}
	
	public static Node parentMapping(Map<Node, Node> parent, Node root, int start) {
		Queue<Node> q = new LinkedList();
		q.add(root);
		Node temp = null;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				if (start == node.data) {
					temp = node;
				}
				if (node.left != null) {
					q.offer(node.left);
					parent.put(node.left, node);
				}

				if (node.right != null) {
					q.offer(node.right);
					parent.put(node.right, node);
				}
			}
		}
		return temp;
	}


    public int countNodes(Node root) {

		if(root==null)
			return 0;
		int leftH=leftHeight(root);
		int rightH=rightHeight(root);

		if(leftH==rightH)
			return (1<<leftH)-1;

		return 1+countNodes(root.left)+countNodes(root.right);

		//TC:O(logN) square
		//SC:O(N)
    }

	private static int rightHeight(Node root) {
		int count=0;
		while(root!=null){
			count++;
			root=root.right;
		}
		return count;
	}

	private static int leftHeight(Node root) {
		int count=0;
		while(root!=null){
			count++;
			root=root.left;
		}
		return count;
	}
}
