package leetcode.principles.InterfaceDemo.variables;

public class Main implements A, B{

    //public static final String s="Main";

    public static void main(String[] args) {

        Main m=new Main();
        System.out.println(m.show());
    }

    @Override
    public String show() {
        return A.super.show() + B.super.show();
    }
}
