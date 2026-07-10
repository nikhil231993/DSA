package leetcode.company.leetcode75Remaining;

public class LC605CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = new int[] {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m=flowerbed.length;
        int count=0;
        for(int i=0;i<m;i++){
            if(flowerbed[i]==0){
                boolean leftEmpty = (i==0) || flowerbed[i-1] == 0;
                boolean rightEmpty = (i==m-1) || flowerbed[i+1] ==0 ;

                if(leftEmpty && rightEmpty){
                    flowerbed[i]=1;
                    count++;
                }
            }
        }
        return count>=n;
    }
}
