package leetcode.array.medium;

import java.util.HashMap;

public class NumberOfSubarraysWithXORK {

    public static void main(String[] args) {

        int[] num=new int[]{4, 2, 2, 6, 4};
        int target=6;

        //Approach 1: Brute 3 loops

        //Approach 2: Better Similar to 560 using two for loops
        System.out.println(subarraysWithXorKBrute(num, target));

        //Approach 3: Optimal
        System.out.println(optimal(num,target));
    }

    public static int subarraysWithXorKBrute(int []a, int k) {

        int n = a.length; //size of the given array.
        int cnt = 0;

        // Step 1: Generating subarrays:
        for (int i = 0; i < n; i++) {
            int xorr = 0;
            for (int j = i; j < n; j++) {

                //step 2:calculate XOR of all
                // elements:
                xorr = xorr ^ a[j];

                // step 3:check XOR and count:
                if (xorr == k) cnt++;
            }
        }
        return cnt;

        //TC:O(n square)
        //SC:O(1)
    }

    private static int optimal(int[] num, int target) {

        int count=0;
        int n=num.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int xor=0;

        for(int i=0;i<n;i++){
            xor=xor^num[i];
            if(xor==target)
                count++;
            if(map.containsKey(xor^target))
                count+=map.get(xor^target);
            map.put(xor,map.getOrDefault(xor,0)+1);
        }

        return count;

        //TC:O(N)* time complexity of map O(1) in case of unordered map or log n (ordered map)
        //SC:O(N)
    }

}
