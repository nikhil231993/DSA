package leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC599MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {

        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 =new String[] {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

        String[] r=findRestaurant(list1,list2);

        for(String s:r)
            System.out.println(s);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map=new HashMap();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }

        List<String> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;

        for(int i=0;i<list2.length;i++){
            Integer j=map.getOrDefault(list2[i],-1);
            if(j!=-1 && j+i<=min){
                if(i+j < min){
                    result.clear();
                    min=i+j;
                }
                result.add(list2[i]);
            }
        }
        return result.toArray(new String[result.size()]);

        //TC:O(n+m)
        //SC:O(k)
    }
}
