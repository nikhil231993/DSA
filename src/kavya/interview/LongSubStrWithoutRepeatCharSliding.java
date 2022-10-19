package kavya.interview;

public class LongSubStrWithoutRepeatCharSliding {
    public static int lengthOfLongestSubstring(String str)
    {
        int n = str.length();
        int res = 0;

        for(int i = 0; i < n; i++)
        {

            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {
                if (visited[str.charAt(j)] == true)
                    break;

                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                    System.out.println(str.charAt(j) + " " +visited[str.charAt(j)]);
                }
            }
            visited[str.charAt(i)] = false;
            System.out.println(str.charAt(i));
        }
        return res;
    }

    public static void main(String args[]) {
        // Your code goes here
        String s = "Hello";
        LongSubStrWithoutRepeatCharSliding ob = new LongSubStrWithoutRepeatCharSliding();
        System.out.println(ob.lengthOfLongestSubstring(s));
    }
}
