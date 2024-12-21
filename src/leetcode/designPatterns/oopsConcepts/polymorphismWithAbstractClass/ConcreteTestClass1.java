package leetcode.designPatterns.oopsConcepts.polymorphismWithAbstractClass;

public class ConcreteTestClass1 extends AbstractTest {

    public ConcreteTestClass1(){
    }

    public ConcreteTestClass1(AbstractTest test) {
        super(test);
    }

    public String getName() {
        return "Nikhil";
    }

    public String display(){
        return test.getName() + "Test2";
    }
}
