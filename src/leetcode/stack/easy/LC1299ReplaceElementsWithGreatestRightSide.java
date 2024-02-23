package leetcode.stack.easy;

import java.util.Arrays;

public class LC1299ReplaceElementsWithGreatestRightSide {

    public static void main(String[] args) {

        int[] arr =new int[] {17,18,5,4,6,1};
        System.out.println(replaceElements(arr));
    }

    public static int[] replaceElements(int[] arr) {


        int[] ans=new int[arr.length];

        Arrays.fill(ans, -1);

        int n=arr.length;

        int largest=Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(largest==Integer.MIN_VALUE){
                largest=Math.max(largest, arr[i]);
                continue;
            } else{
                ans[i]=largest;
                largest=Math.max(largest, arr[i]);
            }
        }
        return ans;
    }
}
