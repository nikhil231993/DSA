package leetcode.principles.abstractContructor;

public abstract class Base {

    public Base(){
        System.out.println("Base abstract class non parameterized constructor");
    }

    public Base(String name){ // abstract classes can have constructor
        System.out.println("Base abstract class parameterized constructor "+ name);
    }

    public void display(){
        System.out.println("Base abstract class display function");
    }
}
