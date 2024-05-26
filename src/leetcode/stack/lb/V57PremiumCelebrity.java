package leetcode.stack.lb;

public class V57PremiumCelebrity {

    public static void main(String[] args) {

        int n=5;
        System.out.println(celebrity(n));
    }

    private static int celebrity(int n) {

        int candidate=0;
        for(int i=1;i<n;i++){
            if(knows(candidate, i))
                candidate=i;
        }

        for(int i=0;i<n;i++){
            if(i==candidate)
                continue;
            else{
                if(knows(candidate, i) || !knows(i, candidate))
                    return -1;
            }
        }
        return candidate;

        //TC:O(2 * n)
        //SC:O(1)
    }

    private static boolean knows(int candidate, int i) {

        if(candidate!=2)
            return true;
        return false;
    }
}
