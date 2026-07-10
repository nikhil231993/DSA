package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class LC2553 {

    public static void main(String[] args) {
        int[] nums =new int[] {13,25,83,77};
        int[] result=separateDigits(nums);
        for(int no:result)
            System.out.println(no);
    }

    private static int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){

            if(nums[i]<10)
                list.add(nums[i]);
            else{
                int pos=list.size();
                while(nums[i]>9){
                    int lastDigit=nums[i]%10;
                    list.add(pos, lastDigit);
                    nums[i]=nums[i]/10;
                }
                list.add(pos, nums[i]);
            }
        }
        return list.stream().mapToInt(a->a).toArray();
    }
}
