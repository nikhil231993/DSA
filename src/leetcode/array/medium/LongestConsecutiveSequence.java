package leetcode.array.medium;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] num=new int[]{100, 200, 1, 3,101,102,103,104, 2, 4};

        //Brute
        //Use 2 for loops to parse through each element and find if next greater element exist in the array
        //code in book
        //TC:O(N square)

        //Better
        System.out.println(betterApproach(num));

        //Optimal
        //Step 1: Put all the values in set
        //Step 2: Take each element from set and see if lesser no exist
        //Step 3: If lesser no does not exist then that no is the smallest no and also the first no
        System.out.println(optimalApproach(num));
    }

    private static int optimalApproach(int[] num) {
        int n=num.length;
        HashSet<Integer> hash=new HashSet<>();

        for(int i=0;i<n;i++)
            hash.add(num[i]);
        int count=0;
        int len=0;
        for(Integer no:hash){
            if(!hash.contains(no-1)){
                int small=no;
                count=1;

                while(hash.contains(no+1)){
                    count++;
                    no=no+1;
                }
            }
            len=Math.max(len,count);
        }
        return len;
    }

    private static int betterApproach(int[] num) {

        Arrays.sort(num);
        int count=0;
        int len=0;
        int lastSmaller=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
        if(num[i]-1==lastSmaller){
            count++;
            lastSmaller=num[i];
        }else if(num[i]!=lastSmaller){
            count=1;
            lastSmaller=num[i];
        }
        len=Math.max(len,count);
        }
        return len;
        //TC:O(nlogn)
        //SC:O(1)
    }
}
