package leetcode.heap.easy;

public class LC2278PercentageOfLetterInString {

    public static void main(String[] args) {

        String s = "foobar";
        char letter = 'o';

        System.out.println(percentageLetter(s,letter));
    }

    public static int percentageLetter(String s, char letter) {

        int count=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)==letter)
                count++;
        return (int)(((double)count/(double)s.length())*100);

        //TC:O(n)
        //SC:O(1)
    }
}
