package learningLogic.Stack;

public class StackCustomUsingLinkedList {
	
	StackNode top;
	
	class StackNode{
		private int data;
		private StackNode next;
		
		public StackNode(int data) {
			this.data=data;
		}
		
	}

	public void push(int data) {
		
		StackNode node =new StackNode(data);
		node.next=top;
		top=node;
		System.out.println(top.data+" pushed to stack");
		
	}

	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int value= top.data;
		top=top.next;
		return value;
	}

	public int peek() {	
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}


	public boolean isEmpty() {
		return top==null;
	}

}
