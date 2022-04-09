package learningLogic;

public class recursiveMin {

	public static void main(String[] args) {
		 int A[] = {1, 4, 45, 6, -50, 10, 2};
	        int n = A.length;
	        int min=A[n-1];
	        System.out.println(findMinRec(A, n-1,min));

	}
	
	public static int findMinRec(int[] arr,int n,int min)
	{
		
		if (n<=1)
			return min;
		else {
			if(arr[n] < min)
				min=arr[n];
		return findMinRec(arr, n-1,min);
		}
		
	}

}
