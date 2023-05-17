package leetcode.recursion;

public class Test {

    public static void main(String[] args) {
        int count=0;
        int[] cnt=new int[1];
        recursion(count);
        System.out.println(count);
    }

    private static void recursion(int count) {

        if(count==5)
            return ;
        count++;
        recursion(count);
        System.out.println(count);

    }
}
