package leetcode.array.extra;

public class gfgLargestElement {

    public static void main(String[] args) {

        int n = 5;
        int A[] =new int[] {1, 8, 7, 56, 90};
        System.out.println(largest(A,n));
    }

    public static int largest(int arr[], int n)
    {
        int max=Integer.MIN_VALUE;
        for(Integer num:arr)
            max=Math.max(max,num);
        return max;

        //TC:O(n)
        //SC:O(1)
    }
}
