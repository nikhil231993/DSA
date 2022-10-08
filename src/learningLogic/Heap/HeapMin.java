package learningLogic.Heap;

public class HeapMin {

	public int[] heap;
	public int currentSize;

	public HeapMin(int size) {
		heap = new int[size + 1];
		currentSize = 0;
	}

	public void insert(int key) {
		if (currentSize < heap.length) {
			heap[++currentSize] = key;
			int currentPos = currentSize;
			while (heap[currentPos] < heap[currentPos / 2]) {
				int temp = heap[currentPos / 2];
				heap[currentPos / 2] = heap[currentPos];
				heap[currentPos] = temp;
				currentPos = currentPos / 2;
			}

		} else {
			System.out.println("Heap is full");
			return;

		}

	}

	public void print() {
		for (int i = 1; i <= currentSize / 2; i++) {


			System.out.print(
					" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);


			System.out.println();
		}
	}

}
