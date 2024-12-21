package leetcode.designPatterns.oopsConcepts.polymorphismWithAbstractClass;

public abstract class AbstractTest {

    public AbstractTest test;

    public AbstractTest(){
    }

    public AbstractTest(AbstractTest test){
        this.test=test;
    }

    public abstract String getName();
}
