package leetcode.principles.InterfaceDemo.variables;

public interface B {

    public static final String s="B";

    default String show(){
       return "B";
    }
}
