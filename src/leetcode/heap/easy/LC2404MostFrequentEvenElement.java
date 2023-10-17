package leetcode.heap.easy;

import java.util.HashMap;
import java.util.Map;

public class LC2404MostFrequentEvenElement {

    public static void main(String[] args) {
        int[] nums =new int[] {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map=new HashMap();
        for(Integer num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int count=-1;
        int element=Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            Integer c=m.getKey();
            Integer val=m.getValue();
            if(val==count && c%2==0 && c<element){
                count=val;
                element=c;
            } else if (val>count && c%2==0) {
                count=val;
                element=c;
            }
        }
        return element==Integer.MAX_VALUE?-1:element;
        //TC:O(n)
        //SC:O(n) in worst case where each element is unique
    }
}
