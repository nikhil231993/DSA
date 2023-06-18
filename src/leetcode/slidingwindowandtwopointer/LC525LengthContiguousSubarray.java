package leetcode.slidingwindowandtwopointer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC525LengthContiguousSubarray {

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,1,0,0,1,0,1};

        //Brute force
        System.out.println(bruteForce(nums));

        //best approach
        //Step 1: convert all 0 to -1 as the sum of 1 , -1 will be 0 which means it has equal no of 0 and 1
        //Step 2: If the sum is 0 then len is calculated as i+!
        //step 3. Store only 1st occurrence of numbers in map so to get max length;
        //step 4: If map has the sum then i- map.get(sum)
        System.out.println(findMaxLength(nums));
    }

    private static int bruteForce(int[] nums) {
        int n=nums.length;
        int len=0;
        for(int i=0;i<n;i++){
            int zC=0,oC=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0)
                    zC++;
                else if(nums[j]==1)
                    oC++;
                if(zC==oC)
                    len=Math.max(len,j-i+1);
            }
        }
        return len;
        //TC:O(N square)
        //TC:O(1)
    }

    public static int findMaxLength(int[] nums) {

        int len=0;
        int sum=0;
        int n=nums.length;
        HashMap<Integer, Integer> map=new LinkedHashMap();
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                nums[i]=-1;
        }

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==0)
                len=Math.max(len, i+1);
            if(map.containsKey(sum)){
                len=Math.max(len, i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return len;
        //TC:o(N)
        //SC:o(N)
    }
}
