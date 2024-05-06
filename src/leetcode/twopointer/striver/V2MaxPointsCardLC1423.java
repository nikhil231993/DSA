package leetcode.twopointer.striver;

public class V2MaxPointsCardLC1423 {

    public static void main(String[] args) {

       int[] cardPoints =new int[] {1,2,3,4,5,6,1};
       int k = 3;
       System.out.println(maxScore(cardPoints,k));
    }

    public static int maxScore(int[] cardPoints, int k) {

        int lsum=0;
        for(int i=0; i<k; i++){  //O(k)
            lsum+=cardPoints[i];
        }

        int maxSum=lsum;
        int rsum=0;

        int l=k-1, r=cardPoints.length-1;
        while(l>=0){  //O(k)
            lsum-=cardPoints[l--];
            rsum+=cardPoints[r--];
            maxSum=Math.max(maxSum, lsum+rsum);
        }
        return maxSum;

        //TC:O(k) + O(k)
        //SC:O(1)
    }
}
