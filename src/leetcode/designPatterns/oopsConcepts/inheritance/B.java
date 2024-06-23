package leetcode.designPatterns.oopsConcepts.inheritance;

public class B extends A{

    public B(){
        System.out.println("child class");
    }

    public B(String name){
//      super(name);
        System.out.println("child class:"+ name);
    }

    @Override
    public void print() {
        System.out.println("class B");
        super.print();
    }
}
