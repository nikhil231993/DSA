package leetcode.designPatterns.oopsConcepts.multipleinheritance.diamondProblem;

public class TestClass implements PI1, PI2 {

    @Override
    public void show() {
        PI1.super.show();
        PI2.super.show();
    }

    public static void main(String[] args) {

        TestClass test=new TestClass();
        test.show();
    }
    //NOTES: https://www.geeksforgeeks.org/java-and-multiple-inheritance/
}
