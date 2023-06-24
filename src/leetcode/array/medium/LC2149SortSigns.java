package leetcode.array.medium;

public class LC2149SortSigns {

    public static void main(String[] args) {
       int[] nums =new int[] {3,1,-2,-5,2,-4};

        int[] res=rearrangeArray(nums);

        for(int n:res)
            System.out.println(n);
    }

    public static int[] rearrangeArray(int[] nums) {

        int n=nums.length;
        int posIndx=0;
        int negIndx=1;
        int[] ans=new int[n];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negIndx]=nums[i];
                negIndx+=2;
            }else{
                ans[posIndx]=nums[i];
                posIndx+=2;
            }
        }

        return ans;
        //TC:O(N)
        //SC:O(N)
    }
}
