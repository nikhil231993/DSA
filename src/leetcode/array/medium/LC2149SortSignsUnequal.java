package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC2149SortSignsUnequal {

    public static void main(String[] args) {

        int[] num=new int[] {1,2,-3,-1,-2,-3,4};

        sort(num);

        for(int n : num)
            System.out.println(n);
    }

    private static void sort(int[] nums) {

        int n=nums.length;
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();

        for(int i=0; i<n; i++) {
            if (nums[i] < 0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }

        if(pos.size() < neg.size()){
            for(int i=0; i<pos.size(); i++){
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }
            int index=pos.size()*2;
            for(int i=pos.size(); i<neg.size(); i++)
                nums[index++]=neg.get(i);
            }
        else{
            for(int i=0; i<neg.size(); i++){
                nums[2*i] = pos.get(i);
                nums[2*i+1] = neg.get(i);
            }
            int index=neg.size()*2;
            for(int i=neg.size(); i<pos.size(); i++)
                nums[index++] = pos.get(i);
        }
    }
}
