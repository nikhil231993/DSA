package leetcode.array.medium;

public class LC1497DivisiblebyKToLearn {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,10,6,7,8,9};
        int k=5;
        System.out.println(canArrange(nums,k));

    }

    public static boolean canArrange(int[] arr, int k) {
        int result=0;
        int[] res=new int[k];
        for(int i:arr){
            int value=i%k;
            if(value==0){
                result=result+res[0];
            }else{
                result=result+res[k-value];
            }
            res[value]++;
        }
        if(result+1==arr.length)
            return true;
        return false;

    }
}
