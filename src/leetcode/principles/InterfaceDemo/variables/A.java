package leetcode.principles.InterfaceDemo.variables;

public interface A {

    public static final String s="A";

    default String show(){
        return "A";
    }
}
