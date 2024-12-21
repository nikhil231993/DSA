package leetcode.designPatterns.oopsConcepts.polymorphismWithAbstractClass;

public class ConcreteTestClass2 extends AbstractTest {

    public ConcreteTestClass2(){
    }

    public ConcreteTestClass2(AbstractTest test) {
        super(test);
    }

    public String getName() {
        return "Kavya";
    }

    public String display(){
        return test.getName()+ "Test1";
    }
}
