package leetcode.principles.hashcodeAndEquals;

import java.util.HashMap;
import java.util.Objects;

class Student {

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class Main {

    public static void main(String[] args) {

        HashMap<Student, String> map=new HashMap<>();
        Student s1=new Student(1, "Nikhil");
        Student s2=new Student(1, "Nikhil");
        Student s3=new Student(1, "Nikhil");
        map.put(s1, "topper");
        map.put(s2, "second");
        System.out.println(map.get(s3));
    }
}
