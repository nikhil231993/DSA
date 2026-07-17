package leetcode.company.meta;

public class LC1967 {

    public static void main(String[] args) {
        String[] patterns = new String[] {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(numOfStrings(patterns, word));
    }

    private static int numOfStrings(String[] patterns, String word) {
        int n=patterns.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(word.indexOf(patterns[i])!=-1)
                count++;
        }
        return count;
    }
}
