package leetcode.slidingwindowandtwopointer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC904FruitBaskets {

    public static void main(String[] args) {
        int[] fruits=new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int k=2;

        System.out.println(maxFruits(fruits));
    }

    private static int maxFruits(int[] fruits) {

        int left=0;
        int len=0;

        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int j=0;j<fruits.length;j++){
            if(map.containsKey(fruits[j])){
                map.put(fruits[j],map.get(fruits[j])+1);
            }else{
                map.put(fruits[j],1);
                while(map.size()>2){
                    if(map.get(fruits[left])==1)
                        map.remove(fruits[left]);
                    else
                       map.put(fruits[left],map.get(fruits[left])-1);
                    left++;
                }
            }
            len=Math.max(len,j-left+1);
        }
        return len;
        //TC:O(2N)
        //SC:O(N)
    }
}
