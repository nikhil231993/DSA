package leetcode.binarysearch;

public class BS12KokoEatingBananaLC875 {

    public static void main(String[] args) {

        int[] piles=new int[]{3,6,7,11};
        int h=8;
//        int[] piles =new int[] {30,11,23,4,20};
//        int h = 5;
        System.out.println(minimumCount(piles,h));
    }

    private static int minimumCount(int[] piles, int h) {

        int max=findmax(piles,h);

        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=isPossible(mid,piles,h);
            if(count<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;

        //TC:O(N)* log (max(element)) + O(N)
        //SC:O(1)
    }

    private static int isPossible(int mid, int[] piles, int h) {

        int count=0;
        for(int i=0;i<piles.length;i++) {  //O(N)
            count+=Math.ceil((double)piles[i]/(double)mid);
        }
        return count;
    }

    private static int findmax(int[] piles, int h) {

        int max=Integer.MIN_VALUE;
        for(Integer num:piles)
            max=Math.max(max,num);
        return max;

    }
}
