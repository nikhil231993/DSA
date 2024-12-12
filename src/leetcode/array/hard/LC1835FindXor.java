package leetcode.array.hard;

public class LC1835FindXor {

    public static void main(String[] args) {

        int[] arr1 =new int[] {1,2,3};
        int[] arr2 =new int[] {6,5};

        //1st Approach : Two for loops

        //Best Approach
        System.out.println(getXORSum(arr1, arr2));
    }

    public static int getXORSum(int[] arr1, int[] arr2) {

        int n=arr1.length, m=arr2.length;
        int xor1=0, xor2=0;
        for(int i=0;i<n;i++){
            xor1^=arr1[i];
        }
        for(int j=0;j<m;j++){
            xor2^=arr2[j];
        }
        return xor1 & xor2;
    }
}
