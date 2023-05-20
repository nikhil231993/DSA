package learningLogic.recursion.striver;

public class V15PermutationsString {

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n);
    }

    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i < r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    //Time Complexity: O(N * N!) Note that there are N! permutations and it requires O(N) time to print a permutation.
    //Auxiliary Space: O(R – L)

}
