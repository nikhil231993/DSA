package leetcode.designPatterns.oopsConcepts.finalclass;

public class DriverClass {

    public static void main(String[] args) {

        Burger b=new Burger();
        b.display();
        //final classes cannot be extended
        //final methods cannot be overridden
        //final variables cannot be changed
    }
}
