package revision.Heap;

public class HeapMax {
	protected int[] heap;
	protected int currentLocationMax;

	public HeapMax(int size) {
		heap=new int[size+1];
		currentLocationMax = 0;
	}

	public void insert(int key) {
		if (currentLocationMax < heap.length) {

			heap[++currentLocationMax] = key;
			int tempCurrentLocation = currentLocationMax;
			while (heap[tempCurrentLocation] > heap[tempCurrentLocation / 2] && tempCurrentLocation / 2 > 0) {
				int temp = heap[tempCurrentLocation];
				heap[tempCurrentLocation] = heap[tempCurrentLocation / 2];
				heap[tempCurrentLocation / 2] = temp;
				tempCurrentLocation = tempCurrentLocation / 2;

			}
		}

	}

	public void print() {
		for (int i = 1; i <= currentLocationMax / 2; i++) {
			System.out.print("parent: " + heap[i]);
			if (2 * i <= heap.length) {
				System.out.print("Left: " + heap[2 * i]);
			}
			if (2 * i + 1 < heap.length) {
				System.out.print("Right: " + heap[2 * i + 1]);
			}
			System.out.println();
		}

	}

	public int peek() {
		if (currentLocationMax == 0)
			return -1;
		return heap[1];
	}

	public int remove() {
		if (currentLocationMax == 0)
			return -1;

		int removed = heap[1];
		heap[1] = heap[currentLocationMax--];
		maxHeapify(1);
		return removed;
	}

	private void maxHeapify(int pos) {
		
		if (pos > heap.length / 2) {
			System.out.println("We are currently at leaf node so terminating");
			return;
		}
		
		int left=2*pos;
		int right=2*pos+1;
		
		if (left < heap.length || right < heap.length) {
			if (heap[pos] < heap[left] && heap[pos] < heap[right]) {
				if (heap[left] > heap[right]) {
					int temp = heap[left];
					heap[left] = heap[pos];
					heap[pos] = temp;
					maxHeapify(left);
				} else {
					int temp = heap[right];
					heap[right] = heap[pos];
					heap[pos] = temp;
					maxHeapify(right);
				}
			}
			
		}

	}

}
