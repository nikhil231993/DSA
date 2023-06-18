package leetcode.slidingwindowandtwopointer;

import java.util.HashMap;
public class LC1248CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
       int[] nums =new int[] {1,1,2,1,1};
       int k = 3;

        System.out.println(numberOfSubarrays(nums,k));

    }

    //Step 1: change even to 0 and odd nos to 1;
    //Step 2:then find no of sub array with sum equal to 1


    public static int numberOfSubarrays(int[] nums, int k) {

        int n=nums.length;

        for(int i=0; i<n;i++){
            if(nums[i]%2==0)
                nums[i]=0;
            else if(nums[i]%2==1)
                nums[i]=1;
        }

        HashMap<Integer, Integer> m=new HashMap();
        m.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(m.containsKey(sum-k)){
                count+=m.get(sum-k);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;

    }
}
