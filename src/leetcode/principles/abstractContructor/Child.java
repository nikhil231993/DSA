package leetcode.principles.abstractContructor;

public class Child extends Base{

    public Child(){
        System.out.println("Child abstract class non parameterized constructor");
    }

    public Child(String name){
        super(name);
    }

    @Override
    public void display(){
        System.out.println("Child abstract class display function");
    }
}
