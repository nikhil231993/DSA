package revision.stack;

public class FixedStackDynamic extends FixedStack {

	public FixedStackDynamic() {
		super();
	}

	public FixedStackDynamic(int size) {
		super(size);
	}

	@Override
	public void push(int data) {
		if (isFull()) {

			int[] temp = new int[arr.length * 2];
			for (int i = 0; i < arr.length - 1; i++) {
				temp[i] = arr[i];

			}
			arr = temp;
		}
		super.push(data);

	}
}
