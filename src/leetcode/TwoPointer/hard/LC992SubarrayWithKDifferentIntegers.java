package leetcode.TwoPointer.hard;

import java.util.HashMap;

public class LC992SubarrayWithKDifferentIntegers {

    public static void main(String[] args) {

       int[] nums =new int[] {1,2,1,3,4};
       int k = 3;
       System.out.println(subarraysWithKDistinct(nums,k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int countAtMostThree=subArrayWithAtmostThree(nums,k);
        int countAtMostTwo=subArrayWithAtmostTwo(nums,k-1);

        return countAtMostThree-countAtMostTwo;
    }

    private static int subArrayWithAtmostTwo(int[] num, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int count=0;
        while(right<num.length){
            map.put(num[right],map.getOrDefault(num[right],0)+1 );
            if(map.size()<=k){
                count+=right-left+1;
            }
            while(map.size()>k){
                if(map.get(num[left])==1)
                    map.remove(num[left]);
                else if(map.get(num[left])>1)
                    map.put(num[left], map.get(num[left])-1);
                left++;
                if(map.size()==k)
                    count+=right-left+1;
            }
            right++;
        }
        return count;
    }

    public static int subArrayWithAtmostThree(int[] num, int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int count=0;
        while(right<num.length){
            map.put(num[right],map.getOrDefault(num[right],0)+1 );
            if(map.size()<=k){
                count+=right-left+1;
            }
            while(map.size()>k){
                if(map.get(num[left])==1)
                    map.remove(num[left]);
                else if(map.get(num[left])>1)
                    map.put(num[left], map.get(num[left])-1);
                left++;
                if(map.size()==k)
                    count+=right-left+1;
            }
            right++;
        }
        return count;
    }
}
