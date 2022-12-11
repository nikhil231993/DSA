package revision.Heap;

public class HeapMin {
	protected int[] heap;
	protected int currentLocation;

	public HeapMin(int size) {
		heap=new int[size+1];
		currentLocation = 0;
	}

	public void insert(int key) {
		if (currentLocation < heap.length) {

			heap[++currentLocation] = key;
			int tempCurrentLocation = currentLocation;
			while (heap[tempCurrentLocation] < heap[tempCurrentLocation / 2]) {
				int temp = heap[tempCurrentLocation];
				heap[tempCurrentLocation] = heap[tempCurrentLocation / 2];
				heap[tempCurrentLocation / 2] = temp;
				tempCurrentLocation = tempCurrentLocation / 2;

			}
		}

	}

	public void print() {
		for (int i = 1; i <= currentLocation / 2; i++) {
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
		if(currentLocation ==0)
			return -1;
		return heap[1];
	}

	public int remove() {
		if (currentLocation == 0)
			return -1;

		int removed = heap[1];
		heap[1] = heap[currentLocation--];
		minHeapify(1);
		return removed;
	}

	private void minHeapify(int pos) {
		
		if (pos >= currentLocation) {
			System.out.println("We are currently at leaf node so terminating");
			return;
		}
		
		int left=2*pos;
		int right=2*pos+1;
		
		if (left < heap.length || right < heap.length) {
			if (heap[pos] > heap[left] && heap[pos] > heap[right]) {
				if (heap[left] < heap[right]) {
					int temp = heap[left];
					heap[left] = heap[pos];
					heap[pos] = temp;
					minHeapify(left);
				} else {
					int temp = heap[right];
					heap[right] = heap[pos];
					heap[pos] = temp;
					minHeapify(right);
				}
			}
			
		}

	}

}
