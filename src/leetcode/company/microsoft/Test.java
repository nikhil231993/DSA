package leetcode.company.microsoft;


class Parent{

    public void display(){
        System.out.println("Parent Display");
    }

    public void subtract(){
        System.out.println("Parent");
    }
}

class Child extends Parent{

    public void display(){
        System.out.println("Children Display");
    }

    public void sum(){
        System.out.println("Children");
    }
}
public class Test {

    public static void main(String[] args) {
        Parent p=new Child();
        p.display();
        p.subtract();
    }
}
