package learningLogic.Heap;

public class HeapMax {

	int[] heap = null;
	int currentPosition;

	public HeapMax(int size) {
		heap = new int[size + 1];
		currentPosition = 0;

	}

	public void insert(int value) {
		if (currentPosition >= heap.length) {
			System.out.println("Cannot insert element as heap mempry is exhausted");
			return;
		}

		heap[++currentPosition] = value;
		int tempLocation = currentPosition;
		
		while (heap[tempLocation / 2] < heap[tempLocation] && tempLocation / 2 > 0) {
			int temp = heap[tempLocation / 2];
			heap[tempLocation / 2] = heap[tempLocation];
			heap[tempLocation] = temp;
			tempLocation = tempLocation / 2;
		}

	}

	public void print() {
		for (int i = 1; i <= currentPosition / 2; i++) {
			System.out.print("Parent: " + heap[i]);
			if (2 * i <= currentPosition) {
				System.out.print(" Left: " + heap[2 * i]);
			}
			if (2 * i + 1 <= currentPosition) {
				System.out.println(" Right: " + heap[2 * i + 1]);
			}
		}

	}

	public int peek() {
		if (currentPosition >= heap.length)
			return -1;
		return heap[1];
	}

	public int remove() {
		if (currentPosition == 0) {
			System.out.println("Heap is empty so cannot remove element");
			return -1;
		}
		int removed = heap[1];
		heap[1] = heap[currentPosition--];

		heapifyTopToBottom(1);

		return removed;
	}

	private void heapifyTopToBottom(int pos) {
		if (pos >= currentPosition) {
			System.out.println("Heaps allocated size is exceeded");
			return;
		}

		int left = 2 * pos;
		int right = 2 * pos + 1;

		if (left < heap.length || right < heap.length) {
			if (heap[pos] < heap[left] && heap[pos] < heap[right]) {
				if (heap[right] > heap[left]) {
					int temp = heap[right];
					heap[right] = heap[pos];
					heap[pos] = temp;
					heapifyTopToBottom(right);

				} else if (heap[left] > heap[right]) {
					int temp = heap[left];
					heap[left] = heap[pos];
					heap[pos] = temp;
					heapifyTopToBottom(left);

				}
			}
		}

	}
}
