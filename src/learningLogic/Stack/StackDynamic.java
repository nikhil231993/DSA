package learningLogic.Stack;

public class StackDynamic extends StackCustomUsingArray {

	public StackDynamic() {
		super();
	}

	public StackDynamic(int size) {
		super(size);
	}

	@Override
	public void push(int value) {
		if (isFull()) {

			int[] temp = new int[data.length * 2];
			for (int i = 0; i < data.length; i++)
				temp[i] = data[i];

			data = temp;
		}
		super.push(value);

	}

}
