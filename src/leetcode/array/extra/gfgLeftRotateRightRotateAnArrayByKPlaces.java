package leetcode.array.extra;

public class gfgLeftRotateRightRotateAnArrayByKPlaces {

    public static void main(String[] args) {

        int[] num=new int[]{1,2,3,4,5,6,7};
        int k=2;
        leftRotate(num, k);

        System.out.println("Left Rotated array by k places is: ");
        for(int n:num)
            System.out.println(n);

        System.out.println("##################################");

        int[] num1=new int[]{1,2,3,4,5,6,7};
        int k1=2;
        rightRotate(num1,k1);

        System.out.println("Right Rotated array by k places is: ");
        for(int n:num1)
            System.out.println(n);
    }

    private static void rightRotate(int[] num, int k) {

        int n=num.length;
        k=k%n;

        reverse(num,0,n-1);
        reverse(num,0,k-1);
        reverse(num,k,n-1);

        //TC:O(N)
        //SC:O(N) as we are using the same array
    }

    private static void leftRotate(int[] num,int k) {

        int n=num.length;
        k=k%n;

        reverse(num,0, n-1);
        reverse(num,0, n-1-k);
        reverse(num,n-k, n-1);

        // TC:O(N)
        // SC:O(N) as we are using the same array
    }

    private static void reverse(int[] num, int start, int end) {

        while(start<end){
            int temp=num[start];
            num[start]=num[end];
            num[end]=temp;
            start++;
            end--;
        }
    }
}
