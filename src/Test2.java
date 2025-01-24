import java.util.HashMap;
import java.util.Map;

public class Test2 {
//    Input: s = "ADOBECODEBANC", t = "ABC"
//    out: ADOBEC, BANC
//
//    mapt = A -> occurance
//    A-> 1
//    B -> 1
//    C -> 1
//
//    maps

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Map<Character, Integer> tMAp = new HashMap<>();
        for (int i = 0 ; i < t.length(); i++) {
            tMAp.put(t.charAt(i), tMAp.getOrDefault(t.charAt(i), 0) +1 );
        }
        Map<Character, Integer> sMAp = new HashMap<>();
        int left = 0;
        String subString = "";
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (tMAp.containsKey(s.charAt(i))) {
                sMAp.put(s.charAt(i), sMAp.getOrDefault(s.charAt(i), 0) +1);
            }
            if (tMAp.size() == sMAp.size()) {
                if (minlen > s.substring(left, i+1).length()) {
                    subString = s.substring(left, i+1);
                }
                minlen = Math.min(minlen, subString.length());

                // shift left pointer
                while (tMAp.containsKey(s.charAt(left)) && sMAp.size() <= tMAp.size() -1) {
                    sMAp.remove(s.charAt(left));
                    left++;
                }

            }

        }
        System.out.println(subString);

    }

}
