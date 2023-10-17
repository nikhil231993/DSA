package leetcode.ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L2ListOfStrings {

    //we can override comparable logic by comparator
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Nikhil","Kavyapppp","Rakesh");
        //Here since Collections.sort has only one parameter so it will call comparable which has compareTo method
        //and will do natural sorting
        Collections.sort(list);
        System.out.println(list);

        //Now Collections.sort has only two parameter so it will call comparator which has compare method which needs
        //two parameters
        //and will do natural sorting
        Collections.sort(list,(a,b)->a.length()-b.length());
        System.out.println(list);

        //we can use line 13 as well as this
        Collections.sort(list,(a,b)->a.compareTo(b));
        System.out.println(list);
    }
}
