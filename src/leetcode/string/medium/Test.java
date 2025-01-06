package leetcode.string.medium;

public class Test {

    public static void main(String[] args) {

        String s1="Nikhil";
        System.out.println(s1.substring(0,0));
        System.out.println(s1.substring(1));
        char[] ch=new char[26];
        String s=new String(ch);
        System.out.println(s);

        StringBuilder sb=new StringBuilder().append("a");
        for(int i=0;i<5;i++){
            sb.append("b");
        }
        System.out.println(sb.toString());
    }
}
