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
				currentPos = currentSize / 2;
			}

		} else {
			System.out.println("Heap is full");
			return;

		}

	}

	public void print() {
		for (int i = 1; i <= currentSize / 2; i++) {

			System.out.print(" PARENT : " + heap[i]);
			if (i * 2 <= currentSize)
				System.out.print(" LEFT CHILD : " + heap[2 * i]);
			if (i * 2 + 1 <= currentSize)
				System.out.print(" RIGHT CHILD :" + heap[2 * i + 1]);

			System.out.println();
		}
	}

	public int peek() {
		if (currentSize == 0) {
			System.out.println("Heap is empty");
			return -1;
		}

		return heap[1];
	}

	public int remove() {
		int removed = heap[1];
		heap[1] = heap[currentSize--];
		minHeapify(1);
		return removed;

	}

	private void minHeapify(int pos) {
		int left = 2 * pos;
		int right = 2 * pos + 1;
		if (pos > heap.length / 2) {
			return;
		} else {

			if (left < heap.length && right < heap.length) {

				if (heap[left] < heap[right]) {
					int temp = heap[pos];
					heap[pos] = heap[left];
					heap[left] = temp;
					minHeapify(left);

				} else {
					int temp = heap[pos];
					heap[pos] = heap[right];
					heap[right] = temp;
					minHeapify(right);
				}
			}
			

		}

	}

}
