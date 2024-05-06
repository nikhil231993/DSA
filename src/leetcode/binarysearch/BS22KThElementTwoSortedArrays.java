package leetcode.binarysearch;

public class BS22KThElementTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,7,8,10};
        int[] nums2 = new int[] {2,3,5,6,9};
        int k=2;

        System.out.println(KthElementInTwoSortedArray(nums1,nums2,k));
    }

    private static int KthElementInTwoSortedArray(int[] nums1, int[] nums2, int k) {

        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2)
            return KthElementInTwoSortedArray(nums2,nums1,k);

        int low=Math.max(0,k-n2); //we should at least take k-n2 if k > n1
        int high=Math.min(k,n1);  //we cannot pick entire n1 if k=2

        int left=k;

        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=k-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];

            if(l1<=r2 && l2<=r1)
                return Math.max(l1,l2);
            else if(l1>r2)
                high=mid1-1;
            else
                low=mid1+1;
        }
        return 0;

        //TC:O(log(min(n1,n2)))
        //SC:O(1)
    }
}
