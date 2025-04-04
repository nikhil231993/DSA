package leetcode.array.easy;

public class LC1732FindHighestAltitude {

    public static void main(String[] args) {

        int[] gain = new int[]{-5,1,5,0,-7};

        //Approach 1: Best
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {

        int value=0, sum=0;

        for(int i=0; i<gain.length; i++){
            sum+=gain[i];
            value=Math.max(value, sum);
        }
        return value;

		//TC:O(n)
		//SC:O(1)
    }
}
