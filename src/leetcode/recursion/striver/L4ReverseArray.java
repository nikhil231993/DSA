package leetcode.recursion.striver;

public class L4ReverseArray {

    public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		reverseArrayWithoutBackTracking(arr, 0, arr.length);
		for (int n : arr)
			System.out.println(n);
		System.out.println("###########");

		int[] arr1 = new int[] { 1, 2, 3, 4, 5};
		reverseArrayWithoutBackTrackingTwoPointer(arr1, 0, arr1.length - 1);
		for (int n : arr1)
			System.out.println(n);

		System.out.println("###########");
		int[] arr2 = new int[] { 1, 2, 3, 4, 5 };
		// Back Tracking
		reverseArray(arr2, 0, arr2.length);
		for (int n : arr2)
            System.out.println(n);

        System.out.println("###########");
		int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        int start=0;
		int end = arr3.length - 1;
		// Back Tracking
		reverseUsingTwoPointer(arr3, start, end);
		for (int n : arr3)
            System.out.println(n);
    }

	private static void reverseArrayWithoutBackTrackingTwoPointer(int[] arr, int start, int end) {

		if (start > end)
			return;
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverseArrayWithoutBackTrackingTwoPointer(arr, start + 1, end - 1);
	}

	private static void reverseArrayWithoutBackTracking(int[] arr, int i, int length) {

		if (i == length / 2)
			return;
		int temp = arr[i];
		arr[i] = arr[length - i - 1];
		arr[length - i - 1] = temp;
		reverseArrayWithoutBackTracking(arr, i + 1, length);
	}

	private static void reverseUsingTwoPointer(int[] arr, int start, int end) {

		if (start > end)
            return;
		reverseUsingTwoPointer(arr, start + 1, end - 1);
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

    private static void reverseArray(int[] arr, int i, int length) {

        if(i==length/2){
            return;
        }
        reverseArray(arr,i+1,length);
        int temp=arr[i];
        arr[i]=arr[length-i-1];
        arr[length-i-1]=temp;
        //TC:O(N)
        //SC:O(N)

    }
}
