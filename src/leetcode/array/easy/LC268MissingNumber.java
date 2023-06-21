package leetcode.array.easy;

public class LC268MissingNumber {

    public static void main(String[] args) {
        int[] num=new int[] {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(num));

        System.out.println(xor(num));
    }

    private static int xor(int[] num) {
    //This is better in case of large numbers as it can not cross the large number
        int XOR1=0;
        int XOR2=0;
        for(int i=0;i<num.length;i++){
            XOR1=XOR1^num[i];
            XOR2=XOR2^i;
        }
        XOR2=XOR2^num.length;

        return  XOR1^XOR2;
    }

    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0,i=0;
        int actualsum=(n)*(n+1)/2;
        for( i=0;i<nums.length;i++)
            sum+=nums[i];
        return actualsum-sum;

        //SC:O(1)
        //TC:O(n)

    }
}
