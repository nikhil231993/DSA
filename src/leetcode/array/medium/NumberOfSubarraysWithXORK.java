package leetcode.array.medium;

import leetcode.array.easy.LC1748SumOfUniqueElements;

import java.util.HashMap;

public class NumberOfSubarraysWithXORK {

    public static void main(String[] args) {
        int[] num=new int[]{4, 2, 2, 6, 4};
        int target=6;

        //optimal
        System.out.println(optimal(num,target));
    }

    private static int optimal(int[] num, int target) {
        int count=0;
        int n=num.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor^num[i];
            if(map.containsKey(xor^target))
                count+=map.get(xor^target);
            map.put(xor,map.getOrDefault(xor,0)+1);
        }

        return count;

        //TC:O(N)* time complexity of map O(1) in case of unordered map or log n (ordered map)
        //SC:O(N)
    }

}
