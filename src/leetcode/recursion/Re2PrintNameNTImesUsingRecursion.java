package leetcode.recursion;

public class Re2PrintNameNTImesUsingRecursion {

    public static void main(String[] args) {

        String name="Nikhil";
        recursion(name,0,5);
    }

    private static void recursion(String name, int i,int n) {
        if(i==n)
            return;
        System.out.println(name);
        recursion(name,i+1,n);
        //TC:O(n)
        //SC:O(n) recursion stack
    }
}
