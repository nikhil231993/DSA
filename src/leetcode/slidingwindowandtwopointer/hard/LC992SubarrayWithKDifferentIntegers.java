package leetcode.slidingwindowandtwopointer.hard;

import java.util.HashMap;

public class LC992SubarrayWithKDifferentIntegers {

    public static void main(String[] args) {
        int[] nums =new int[] {1,2,1,3,4};
        int k = 3;

        //Same as Premium Longest
        //Step 1: Find Atmost k
        //Step 2: Find atmost k-1
        //Step 3: Subtract step 1-step 2
        System.out.println(subarrayWithAtmostK(nums,k)-subarrayWithAtmostK(nums,k-1));

    }

    public static int subarrayWithAtmostK(int[] nums, int k) {

        int n=nums.length;
        int l=0,r=0;
        HashMap<Integer, Integer> m=new HashMap();
        int count=0;
        while(r<n){
            Integer rc=nums[r];
            if(m.containsKey(rc))
                m.put(rc,m.get(rc)+1);
            else{
                m.put(rc,1);
                while(m.size()>k){
                    Integer lc=nums[l];
                    if(m.get(lc)==1)
                        m.remove(lc);
                    else{
                        m.put(lc,m.get(lc)-1);
                    }
                    l++;
                }
            }
            count+=r-l+1;
            r++;
        }
        return count;
        //TC:o(2n)
        //SC:O(N)
    }
}
