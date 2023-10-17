package leetcode.heap.easy;

import java.util.HashMap;
import java.util.Map;

public class LC387FirstUniqueCharacterInString {
    public static void main(String[] args) {
        String s="aabb";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> m=new HashMap();
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i)))
                m.put(s.charAt(i),-1);
            else
                m.put(s.charAt(i),i);
        }

        int index=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> map:m.entrySet()){
            if(map.getValue()<index && map.getValue()!=-1)
                index=map.getValue();
        }
        return index==Integer.MAX_VALUE?-1:index;
        //TC:O(n)
        //SC:O(n)
    }
}
