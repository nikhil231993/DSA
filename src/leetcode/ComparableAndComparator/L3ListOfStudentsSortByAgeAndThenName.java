package leetcode.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    int age;
    String firstName;
    String lastName;

    public Student(int age, String firstName, String lastName){
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
public class L3ListOfStudentsSortByAgeAndThenName {

    public static void main(String[] args) {

        Comparator<Student>  st=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age!=o2.age)
                    return 1;
                else{
                    if(!o1.firstName.equals(o2.firstName)){
                        return o1.firstName.compareTo(o2.firstName);
                    }
                }
                return-1;
            }
        };
        List<Student> list=new ArrayList<>();
        list.add(new Student(100,"Nikhil","T"));
        list.add(new Student(1,"Kavya","m"));
        list.add(new Student(10,"Za","l"));
        list.add(new Student(10,"Abhi","l"));

        //Sorting by age
        Collections.sort(list,(a,b)->a.age-b.age);

        //Sorting by name
        Collections.sort(list,st);
        System.out.println(list);
    }
}
