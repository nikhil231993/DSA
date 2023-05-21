package leetcode.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L5ListOfStudentsAnonymous {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People(100, "Nikhil", "T"));
        list.add(new People(1, "Kavya", "m"));
        list.add(new People(10, "Az", "l"));
        list.add(new People(10, "Abhi", "l"));

        //Sort by age
        Collections.sort(list, (a, b) -> {
            return a.age - b.age;

        });
        System.out.println(list);

        //Sort by name
        Collections.sort(list,(a,b)->{
            //Strings can be compare using compareTo only
            return a.firstName.compareTo(b.firstName);
        });
        System.out.println(list);

        //Sort by both age and name
        Collections.sort(list,(a,b)->{
            if(a.age!=b.age){
                return a.age-b.age;
            }else{
                if(!a.firstName.equals(b.firstName)){
                    return a.firstName.compareTo(b.firstName);
                }
            }
            return -1;
        });

        System.out.println(list);

    }
}
