package leetcode.company.meta;

public class LC2185 {

    public static void main(String[] args) {

        String[] words =new String[] {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    public static int prefixCount(String[] words, String pref) {
        int count=0;
        int n=words.length;
        for(int i=0;i<n;i++){

            if(words[i].indexOf(pref)==0)
                count++;
        }
        return count;
    }
}
