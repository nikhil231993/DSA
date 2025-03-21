package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BS19PaintersPartition {

    public static void main(String[] args) {

//      ArrayList<Integer> num = new ArrayList<>(Arrays.asList(7,2,5,10,8));
//      int k = 2;

        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        System.out.println(splitArray(num, k));
    }

    public static int splitArray(ArrayList<Integer> boards, int k) {

        int max=Integer.MIN_VALUE, sum=0;

        for(Integer num:boards){
            max=Math.max(max, num);
            sum+=num;
        }

        int low=max, high=sum, ans=0;

        while(low <= high){
            int mid=low+(high-low)/2;
            if(possible(mid, boards, k)){
                high=mid-1;
                ans=mid;
            }else
                low=mid+1;
        }
        return ans;
    }

    public static boolean possible(int mid, ArrayList<Integer> a, int k) {

        int count = 1, sum = 0;

        for (Integer num : a) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }
        if (count <= k)
            return true;
        return false;

        //TC:O(log (sum-max+1))* O(n)
        //SC:O(1)
    }
}
