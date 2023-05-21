package leetcode.ComparableAndComparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class People{

    int age;
    String firstName;
    String lastName;

    public People(int age, String firstName, String lastName){
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class PeopeleCompare implements Comparator<People>{

    @Override
    public int compare(People o1, People o2) {
        if(o1.age!=o2.age){
            return o1.age-o2.age;
        }else{
            if(!o1.firstName.equals(o2.firstName)){
                return o1.firstName.compareTo(o2.firstName);
            }
        }
        return -1;
    }
}
public class L4ListOfStudentsSortByAgeAndThenNameUsingSeparateClass {

    public static void main(String[] args) {
        List<People> list=new ArrayList<>();
        list.add(new People(100,"Nikhil","T"));
        list.add(new People(1,"Kavya","m"));
        list.add(new People(10,"Aa","l"));
        list.add(new People(10,"Abhi","l"));

        Collections.sort(list,new PeopeleCompare());
        System.out.println(list);

    }
}
