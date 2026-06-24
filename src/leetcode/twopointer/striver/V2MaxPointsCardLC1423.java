package leetcode.twopointer.striver;

public class V2MaxPointsCardLC1423 {

    public static void main(String[] args) {

       int[] cardPoints =new int[] {1,2,3,4,5,6,1};
       int k = 3;
       System.out.println(maxScore(cardPoints,k));
    }

    private static int maxScore(int[] cardPoints, int k) {

        int leftSum=0;
        for(int i=0; i<k; i++){   //O(k)
            leftSum+=cardPoints[i];
        }

        int maxSum=leftSum;
        int rightSum=0;

        int l=k-1, r=cardPoints.length-1;
        while(l>=0){  //O(k)
            leftSum-=cardPoints[l--];
            rightSum+=cardPoints[r--];
            maxSum=Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;

        //TC:O(k) + O(k)
        //SC: O(1)
    }
}
