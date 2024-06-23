package leetcode.designPatterns.oopsConcepts.multipleinheritance.methodhiding;

public class DriverClass {

    public static void main(String[] args) {

        Base b=new Base();
        Base c=new Child();
        c.show();
        c.display();

//        Child.show();
//        Base.show();
    }
}
