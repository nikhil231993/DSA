package leetcode.array.medium;

import java.util.ArrayList;

public class LC2149SortSigns {

    public static void main(String[] args) {

        int[] nums =new int[] {3,1,-2,-5,2,-4};

        //Approach 1: Take 2 arrays and run loop
        int[] result=rearrangebySign(nums, nums.length);
        for(int n:result)
            System.out.println(n);

        System.out.println("##################");

        //Approach 2: Optimal
        int[] res=rearrangeArray(nums);
        for(int n:res)
            System.out.println(n);
    }

    public static int[] rearrangebySign(int[] A, int n){

        // Define 2 vectors, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        // Segregate the array into positives and negatives.
        for(int i=0;i<n;i++){
            if(A[i]>0) pos.add(A[i]);
            else neg.add(A[i]);
        }

        // Positives on even indices, negatives on odd.
        for(int i=0;i<n/2;i++){
            A[2*i] = pos.get(i);
            A[2*i+1] = neg.get(i);
        }
        return A;

        //TC:O(2n)
        //SC:O(2n)
    }

    public static int[] rearrangeArray(int[] nums) {

        int n=nums.length;
        int posIndx=0, negIndx=1;

        int[] ans=new int[n];

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negIndx]=nums[i];
                negIndx+=2;
            }else{
                ans[posIndx]=nums[i];
                posIndx+=2;
            }
        }
        return ans;

        //TC:O(N)
        //SC:O(N)
    }
}
