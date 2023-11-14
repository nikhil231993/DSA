package leetcode.TwoPointer.hard;

import java.util.HashMap;

public class LC2799CountCompleteSubarrays {

    public static void main(String[] args) {
        int[] nums =new int[] {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }
    public static int countCompleteSubarrays(int[] nums) {

        HashMap<Integer, Integer> map=new HashMap();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int distinctNo=map.size();

        int count=completeSubArray(distinctNo, nums);
        int countLess=completeSubArrayMore(distinctNo-1, nums);//Less than the map size
        return count-countLess;
    }

    public static int completeSubArray(int k, int[] nums){

        HashMap<Integer, Integer> map=new HashMap();
        int right=0, left=0;
        int count=0;
        while(right< nums.length){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            if(map.size()<=k)
                count+=right-left+1;
            while(map.size()>k){
                if(map.get(nums[left])==1)
                    map.remove(nums[left]);
                else if(map.get(nums[left])>1)
                    map.put(nums[left], map.get(nums[left])-1);
                left++;
                if(map.size()==k)
                    count+=right-left+1;
            }
            right++;
        }
        return count;
    }

    public static int completeSubArrayMore(int k, int[] nums){

        HashMap<Integer, Integer> map=new HashMap();
        int right=0, left=0;
        int count=0;
        while(right< nums.length){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            if(map.size()<=k)
                count+=right-left+1;
            while(map.size()>k){
                if(map.get(nums[left])==1)
                    map.remove(nums[left]);
                else if(map.get(nums[left])>1)
                    map.put(nums[left], map.get(nums[left])-1);
                left++;
                if(map.size()==k)
                    count+=right-left+1;
            }
            right++;
        }
        return count;
    }
}
