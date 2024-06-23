package leetcode.designPatterns.oopsConcepts.inheritance;

public class A {

    private static String designation;

    public static void setDesign(String des){
        designation=des;
    }

    public static String getDesignation(){
        return designation;
    }

    private String college;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public A(){
        System.out.println("Parent class");
    }

    public A(String name){
        System.out.println("Parent class: "+name);
    }

    public void print(){
        System.out.println("Class A");
    }
}
