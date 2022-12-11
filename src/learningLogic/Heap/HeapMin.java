package learningLogic.Heap;

public class HeapMin {

	private int[] heap = null;
	private int currentPosition;

	public HeapMin(int size) {
		heap = new int[size + 1];
		currentPosition = 0;
	}

	public void insert(int value) {
		if (currentPosition >= heap.length) {
			System.out.println("Heap is Full");
			return;

		}

		heap[++currentPosition] = value;
		int tempCurrentPosition = currentPosition;

		heapifyBottomToTop(heap, tempCurrentPosition);

	}

	private void heapifyBottomToTop(int[] heap2, int tempCurrentPosition) {
		while (heap[tempCurrentPosition] < heap[tempCurrentPosition / 2]) {
			int temp = heap[tempCurrentPosition];
			heap[tempCurrentPosition] = heap[tempCurrentPosition / 2];
			heap[tempCurrentPosition / 2] = temp;
			tempCurrentPosition = tempCurrentPosition / 2;
		}

	}

	public void print() {
		for (int i = 1; i <= currentPosition / 2; i++) {
			System.out.print("Parent: " + heap[i]);
			if (2 * i < heap.length) {
				System.out.print(" Left: " + heap[2 * i]);
			}
			if (2 * i + 1 < heap.length) {
				System.out.println(" Right: " + heap[2 * i + 1]);
			}
		}

	}

	public int peek() {
		if (currentPosition == 0) {
			System.out.println("Heap is empty");
			return -1;
		}
		return heap[1];
	}

	public int remove() {
		if (currentPosition == 0) {
			System.out.println("Heap is empty");
			return -1;
		}

		int removed = heap[1];
		heap[1] = heap[currentPosition--];

		int pos = 1;
		int left = 2 * pos;
		int right = 2 * pos + 1;
		while (heap.length > left || heap.length > right) {
			if (heap[pos] > heap[left] && heap[pos] > heap[right]) {
				if (heap[right] > heap[left]) {
				int temp = heap[left];
				heap[left] = heap[pos];
				heap[pos] = temp;
				pos = left;
				} else if (heap[right] < heap[left]) {
				int temp = heap[right];
				heap[right] = heap[pos];
				heap[pos] = temp;
				pos=right;
			}
			left = 2 * pos;
			right = 2 * pos + 1;
			}
		}

		return removed;
	}

	// recursive TopToBottom heapify call in remove method
	public int removeRecursive() {
		if (currentPosition == 0) {
			System.out.println("Heap is empty");
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
		int left=2*pos;
		int right = 2 * pos + 1;
		if (left < heap.length && right < heap.length) {
			if (heap[pos] > heap[left] && heap[pos] > heap[right]) {
				if (heap[left] > heap[right]) {
					int temp = heap[pos];
					heap[pos] = heap[right];
					heap[right] = temp;
					heapifyTopToBottom(right);
				} else {
					int temp = heap[pos];
					heap[pos] = heap[left];
					heap[left] = temp;
					heapifyTopToBottom(left);
				}

			}
			
		}

	}
}
