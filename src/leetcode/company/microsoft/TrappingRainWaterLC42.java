package leetcode.company.microsoft;

public class TrappingRainWaterLC42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapTwoPointer(height));
    }

    private static int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
            leftMax[i]=Math.max(leftMax[i-1], height[i]);
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(rightMax[i+1], height[i]);

        int ans=0;
        for(int i=0;i<n;i++)
            ans+=Math.min(leftMax[i], rightMax[i])-height[i];
        return ans;

        //TC:O(3N)
        //SC:O(2N)
    }


    //https://www.youtube.com/watch?v=UHHp8USwx4M
    private static int trapTwoPointer(int[] height) {
        int n=height.length, left=0, right=n-1;

        int leftMax=0, rightMax=0, ans=0;
        while(left<right){
            leftMax=Math.max(leftMax, height[left]);
            rightMax=Math.max(rightMax, height[right]);
            if(leftMax<rightMax){
                ans+=leftMax-height[left];
                left++;
            }else{
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
