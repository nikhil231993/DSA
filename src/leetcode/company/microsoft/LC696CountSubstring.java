package leetcode.company.microsoft;

public class LC696CountSubstring {

    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
        //https://www.youtube.com/watch?v=9N2TwXfTYVY&t=11s
    private static int countBinarySubstrings(String s) {
        int n=s.length();
        int currentGroupCount=1;
        int prevGroupCount=0;
        int count=0;

        for(int i=01;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1))
                currentGroupCount++;
            else{
                count+=Math.min(currentGroupCount, prevGroupCount);
                prevGroupCount=currentGroupCount;
                currentGroupCount=1;
            }
        }
        count+=Math.min(currentGroupCount, prevGroupCount);
        return count;
    }
}
