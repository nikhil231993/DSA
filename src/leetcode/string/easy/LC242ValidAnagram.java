package leetcode.string.easy;

public class LC242ValidAnagram {

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] ch1=new int[255];
        int[] ch2=new int[255];
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2)
            return false;
        for(int i=0;i<n1;i++){
            ch1[s.charAt(i)-'A']++;
        }
        for(int j=0;j<n2;j++){
            ch2[t.charAt(j)-'A']++;
        }
        for(int k=0;k<ch1.length;k++){
            if(ch1[k]!=ch2[k])
                return false;
        }
        return true;
    }
}
