package leetcode.designPatterns.oopsConcepts.inheritance;

public class MainClass {

    public static void main(String[] args) {

         A a=new B("kavya");
         a.print();
         a.setCollege("TKM");

         A.setDesign("TESTER");
         System.out.println("*********");
         System.out.println(B.getDesignation());
         System.out.println("*********");
         
         A a1=new A();
         System.out.println(a1.getCollege());
         System.out.println(a.getCollege());
    }
}
