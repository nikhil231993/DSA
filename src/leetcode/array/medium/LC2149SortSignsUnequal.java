package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC2149SortSignsUnequal {

    public static void main(String[] args) {

        int[] num=new int[] {1,2,-3,-1,-2,-3,4};

        sort(num);

        for(int n : num)
            System.out.print(n+", ");

        //Simpler solution instead of complex if else
        //Here first index will be negative and second will be positive, so we can just add negative and positive numbers
        // in separate lists and then add them back to the original array in the required order
        int[] num1=new int[] {1,2,-3,-1,-2,-3,4};
        rearrange(num);

        System.out.println("Output: ");

        for(int n : num)
            System.out.print(n+", ");
    }

    public static void rearrange(int[] arr) {

        int k=arr.length;
        ArrayList<Integer> pos=new ArrayList();
        ArrayList<Integer> neg=new ArrayList();
        for(int i=0;i<k;i++){
            if(arr[i]<0)
                neg.add(arr[i]);
            else
                pos.add(arr[i]);
        }

        int n=pos.size();
        int m=neg.size();

        int i=0,j=0;
        int q=0;
        while(i<n && j<m){
            arr[q++]=neg.get(j);
            arr[q++]=pos.get(i);
            i++;j++;
        }

        while(i<pos.size()){
            arr[q++]=pos.get(i++);
        }
        while(j<neg.size()){
            arr[q++]=neg.get(j++);
        }

        //TC:O(n+m) where n and m are the number of positive and negative numbers respectively
        //SC:O(n+m) for storing positive and negative numbers in separate lists
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
    //TC:O(n+m)
    //SC:O(n+m) for storing positive and negative numbers in separate lists
}
