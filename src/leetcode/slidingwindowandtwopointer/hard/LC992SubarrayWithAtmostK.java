package leetcode.slidingwindowandtwopointer.hard;

import java.util.HashMap;

public class LC992SubarrayWithAtmostK {

    public static void main(String[] args) {
        int[] nums= new int[]{1,2,1,3,4};
        int k=3;
        System.out.println(count(nums,k));

        //Same as premium longest
    }

    private static int count(int[] nums,int k) {
        int n=nums.length;
        int count=0;
        int l=0;
        int r=0;
        HashMap<Integer,Integer> m=new HashMap<>();
        while(r<n){
            Integer rc=nums[r];
            if(m.containsKey(rc))
                m.put(rc,m.get(rc)+1);
            else{
                m.put(rc,1);
                while(m.size()>k){
                    int lc=nums[l];
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
    }
}
