package leetcode.designPatterns.oopsConcepts.polymorphismWithAbstractClass;

public class MainTest {

    public static void main(String[] args) {

        ConcreteTestClass1 t1=new ConcreteTestClass1(); // Change reference to AsbtractTest and see Compile time error
        ConcreteTestClass2 t2=new ConcreteTestClass2(t1); // Change reference to AsbtractTest and see Compile time error
        System.out.println(t2.display());
    }
}
