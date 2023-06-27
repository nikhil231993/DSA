package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC229MajorityElement2 {

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1,3,2,2,2};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {

        int count1=0, count2=0;
        int ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=ele2){
                count1=1;
                ele1=nums[i];
            }else if(count2==0 && nums[i]!=ele1){
                count2=1;
                ele2=nums[i];
            }else if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1) count1++;
            if(nums[i]==ele2) count2++;

        }
        List<Integer> list=new ArrayList();
        if(count1 > (n/3))
            list.add(ele1);
        if(count2 > (n/3))
            list.add(ele2);

        return list;
    }
}
