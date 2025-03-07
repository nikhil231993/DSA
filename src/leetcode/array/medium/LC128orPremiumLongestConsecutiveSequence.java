package leetcode.array.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LC128orPremiumLongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] num=new int[]{100, 200, 1, 3,101,102,103,104, 2, 4};

        //Approach 1: Brute
        //Use 2 for loops to parse through each element and find if next greater element exist in the array
        //code in book

        System.out.println(longestSuccessiveElements(num));
        //TC:O(N square)

        //Approach 2: Better
        System.out.println(betterApproach(num));

        //Approach 3: Optimal
        //Step 1: Put all the values in set
        //Step 2: Take each element from set and see if lesser no exist
        //Step 3: If lesser no does not exist, then that no is the smallest no and also the first no
        System.out.println(optimalApproach(num));
    }

    public static int longestSuccessiveElements(int[] num) {

        if(num.length==0)  return 0;

        int n = num.length; //size of array
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int x = num[i];
            int cnt = 1;

            while (linearSearch(num, x + 1)) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static boolean linearSearch(int []a, int num) {

        int n = a.length; //size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }

    private static int optimalApproach(int[] num) {

        if(num.length==0)  return 0;

        int n=num.length;
        HashSet<Integer> hash=new HashSet<>();

        for(int i=0;i<n;i++)
            hash.add(num[i]);

        int count=0, len=0;

        for(Integer no: hash){
            if(!hash.contains(no-1)){
                count=1;

                while(hash.contains(no+1)){
                    count++;
                    no=no+1;
                }
            }
            len=Math.max(len,count);
        }
        return len;

        //TC:O(n)
        //SC:O(n)
    }

    private static int betterApproach(int[] num) {

        if(num.length==0)  return 0;

        Arrays.sort(num);

        int count=0;
        int len=0;
        int lastSmaller=Integer.MIN_VALUE;

        for(int i=0; i<num.length; i++){

            if(num[i]==lastSmaller)
                continue;

            if(num[i]-1 == lastSmaller){
                count++;
                lastSmaller=num[i];
            }else {
                count=1;
                lastSmaller=num[i];
            }
            len=Math.max(len, count);
        }
        return len;

        //TC:O(n log n)
        //SC:O(1)
    }
}
