package kavya.interview;

public class LargestNoRecurssion {
    public static int findMaxRec(int A[], int n, int large)
    {
        // if size = 0 means whole array
        // has been traversed
        //int large = Integer.MIN_VALUE;
//        if (n ==1) {
//            return A[0];
//        }
        if(n == 0)
            return large;

        else if(A[n-1]> large) {
            large = A[n-1];
        }
        return findMaxRec(A, n-1, large);
    }

    // Driver code
    public static void main(String args[])
    {
        int A[] = {1};
        int n = A.length;
        int larger = 0;

        // Function calling
        System.out.println(findMaxRec(A, n, larger));
    }
}
