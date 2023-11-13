package leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

public class LC1781SumOfBeauty {

    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySum(s));
    }

    public static int beautySum(String s) {

        int n=s.length();
        int sum=0;

        for(int i=0;i<n;i++){
            HashMap<Character, Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(Map.Entry<Character, Integer> m:map.entrySet()){
                    if(m.getValue()>max)
                        max=m.getValue();
                    if(m.getValue()<min)
                        min=m.getValue();
                }
                sum+=max-min;
            }
        }
        return sum;
    }
}
