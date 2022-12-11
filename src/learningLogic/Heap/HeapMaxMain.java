package learningLogic.Heap;

public class HeapMaxMain {
	
	public static void main(String[] args) {
		HeapMax heapMax = new HeapMax(10);
		heapMax.insert(5);
		heapMax.insert(3);
		heapMax.insert(17);
		heapMax.insert(10);
		heapMax.insert(84);
		heapMax.insert(19);
		heapMax.insert(6);
		heapMax.insert(22);
		heapMax.insert(9);
		heapMax.print();

		System.out.println("Peek: " + heapMax.peek());
		System.out.println("Removing the FRONT element: " + heapMax.remove());
		System.out.println("After max heapifying");
		heapMax.print();
	}

}
