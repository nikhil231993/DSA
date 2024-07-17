package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class LC904FruitBaskets {

    public static void main(String[] args) {

        int[] fruits =new int[] {1,2,1};

        //Approach 1: Brute
        System.out.println(bruteFruit(fruits));

        //Approach 2: Better
        System.out.println(betterFruit(fruits));

        //Approach 3: Best
        System.out.println(bestFruit(fruits));
    }

    public static int bestFruit(int[] fruits) {

        Integer maxLen=Integer.MIN_VALUE;

        int n= fruits.length;

        int right=0, left=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        while(right< n){

            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            if(map.size()>2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0)
                    map.remove(fruits[left]);
                left++;
            }
            if(map.size()<=2)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;

        //TC:O(n)
        //SC:O(2) as only two baskets are needed
    }

    public static int betterFruit(int[] fruits) {

        Integer maxLen=Integer.MIN_VALUE;

        int n= fruits.length, right=0, left=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        while(right< n){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0)
                    map.remove(fruits[left]);
                left++;
            }
            if(map.size()<=2)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;

        //TC:O(n+n)
        //SC:O(2)
    }

    private static int bruteFruit(int[] fruits) {

        Integer maxLen=Integer.MIN_VALUE;

        int n= fruits.length;

        for(int i=0; i<n; i++){
            HashSet<Integer> set=new HashSet<>();

            for(int j=i; j<n; j++){

                set.add(fruits[j]);
                if(set.size()<=2){
                    maxLen=Math.max(maxLen, j-i+1);
                }else break;
            }
        }
        return maxLen;

        //TC:O(n square)
        //SC:O(2)
    }
}
