package leetcode.designPatterns.oopsConcepts.multipleinheritance.methodhiding;

public class DriverClass {

    public static void main(String[] args) {

        // Base b=new Base();
        Child c=new Child();
        c.show();
        c.display();

        // Child.show();
        // Base.show();
    }
}
