package leetcode.slidingwindow.hard;

import java.util.HashMap;
import java.util.HashSet;

public class LC992SubarrayWithAtmostK {

    public static void main(String[] args) {

        int[] nums= new int[]{1,2,1,3,4};
        int k=3;

        //old code don't refer this. See below Approach 1 and Approach 2
        System.out.println(count(nums,k));

        //Approach 1: Brute Generate all the subarrays
        System.out.println(brute(nums, k));

        //Approach 2: Better
        System.out.println(subarray(nums, k));

        //we cannot use "if" instead of "while" as in counting we will miss some subarrays. Take an example and try out
        //When we want to find longest length we can use as its to find max length
    }

    private static int subarray(int[] nums, int k) {

        int right=0, left=0, n=nums.length, count=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        while(right<n){

            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){

                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }
            if(map.size()<=k){
                count+=right-left+1;
            }
            right++;
        }
        return count;
    }

    private static int brute(int[] nums, int k) {

        int count=0, n=nums.length;

        for(int i=0; i<n; i++){
            HashSet<Integer> set=new HashSet<>();

            for(int j=i; j<n; j++){
                set.add(nums[j]);
                if(set.size()<=k){
                    count++;
                }else if(set.size()>k)
                    break;
            }
        }
        return count;

        //TC:O(n square) * set TC
        //SC:O(n) in case all the digits are different
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
