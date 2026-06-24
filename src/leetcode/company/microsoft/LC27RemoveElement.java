package leetcode.company.microsoft;

public class LC27RemoveElement {

    public static void main(String[] args) {

        int[] nums =new int[] {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int n=nums.length, k=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=val)
                nums[k++]=nums[i];
        }
        return k;
    }
}
