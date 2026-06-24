package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class LC1431KidsWithGreatestCandies {

    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max=0;
        for(int child: candies){
            if(child > max)
                max=child;
        }
        List<Boolean> list=new ArrayList<>();
        for(int child: candies){
            if(child + extraCandies >= max)
                list.add(true);
            else
                list.add(false);
        }

        return list;
        //SC:O(n)
        //TC:O(n)
    }
}
