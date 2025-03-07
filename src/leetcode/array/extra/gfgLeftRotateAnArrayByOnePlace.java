package leetcode.array.extra;

public class gfgLeftRotateAnArrayByOnePlace {

    public static void main(String[] args) {

        int[] num=new int[] {1,2,3,4,5};

        leftRotate(num);

        System.out.println("Rotated array is: ");
        for(int n:num)
            System.out.println(n);
    }

    private static void leftRotate(int[] num) {

        int temp=num[0];
        for(int i=1; i<num.length; i++){
            num[i-1]=num[i];
        }
        num[num.length-1]=temp;

        //TC:O(N)
        //SC:O(N) we are not using any extra array but we use existing array, so it can be said as N
    }
}
