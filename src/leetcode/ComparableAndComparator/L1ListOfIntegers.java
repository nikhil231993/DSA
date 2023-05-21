package leetcode.ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L1ListOfIntegers {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,2,3,4);
        Collections.sort(list);
        System.out.println(list);
        //Here since Collections.sort has only one parameter so it will call comparable which has compareTo method
        //and will do natural sorting
    }
}
