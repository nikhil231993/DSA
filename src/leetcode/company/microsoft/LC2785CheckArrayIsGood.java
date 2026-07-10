package leetcode.company.microsoft;

public class LC2785CheckArrayIsGood {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 1, 3};
        System.out.println(isGood(nums));
    }

    public static boolean isGood(int[] nums) {
        int n=nums.length;
        int[] result=new int[201];
        for(int i=0;i<n;i++){
            if(nums[i]>=n) return false;
            result[nums[i]]++;
            if(nums[i]!=n-1)
                if(result[nums[i]]>1) return false;
            if(nums[i]==n-1)
                if(result[nums[i]]>2) return false;
        }
        return true;
    }
}
