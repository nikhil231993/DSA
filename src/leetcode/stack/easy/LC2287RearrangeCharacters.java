package leetcode.stack.easy;

public class LC2287RearrangeCharacters {

    public static void main(String[] args) {

        String s = "ilovecodingonleetcode";
        String target = "code";
        System.out.println(rearrangeCharacters(s,target));
    }

    public static int rearrangeCharacters(String s, String target) {

        int[] freqs=findFreq(s);
        int[] freqt=findFreq(target);

        Integer min=Integer.MAX_VALUE;

        for(int i=0; i<freqs.length ;i++){

            if(freqt[i]!=0){
                min=Math.min(freqs[i]/freqt[i], min);
            }
        }
        return min;

        //TC:O(N1+N2+N1)
        //SC:O(N1+N2)
    }

    public static int[] findFreq(String s){

        int[] freq=new int[26];
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }
        return freq;
    }
}
