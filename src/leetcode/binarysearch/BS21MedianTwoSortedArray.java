package leetcode.binarysearch;

public class BS21MedianTwoSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,3,4,7,10,12};
        int[] nums2 = new int[] {2,3,6,15};

        //Approach 1: Brute force
        System.out.println(findMedianSortedArrays(nums1,nums2));

        //Approach 2: Better
        System.out.println(findMedianSortedArraysWithoutSpace(nums1,nums2));

        //Approach 3: Optimal
        System.out.println(findMedianSortedArraysBS(nums1,nums2));
    }

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1=nums1.length, n2=nums2.length;
        int[] nums3=new int[n1+n2];
        int n=n1+n2;

        int i=0, j=0, k=0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                nums3[k++]=nums1[i++];
            }else{
                nums3[k++]=nums2[j++];
            }
        }
        while(i<n1){
            nums3[k++]=nums1[i++];
        }
        while(j<n2){
            nums3[k++]=nums2[j++];
        }
        if(n%2==1)
            return nums3[n/2];
        else
            return (double)((double)(nums3[n/2]+nums3[n/2-1])/(double)2.0);

        //TC:O(n+m)
        //SC:O(n+m)
    }

    public static double findMedianSortedArraysWithoutSpace(int[] nums1, int[] nums2) {

        int n1=nums1.length, n2=nums2.length;
        int n=n1+n2;
        int count=0;
        int index2=n/2, index1=index2-1;
        int i=0,j=0;
        int element1=-1, element2=-1;

        while(i<n1 && j< n2){
            if(nums1[i] < nums2[j]){
                if(count==index1) element1=nums1[i];
                if(count==index2) element2=nums1[i];
                count++;
                i++;
            }else{
                if(count==index1) element1=nums2[j];
                if(count==index2) element2=nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1){
            if(count==index1) element1=nums1[i];
            if(count==index2) element2=nums1[i];
            count++;
            i++;
        }
        while(j<n2){
            if(count==index1) element1=nums2[j];
            if(count==index2) element2=nums2[j];
            count++;
            j++;
        }
        if(n%2==1)
            return element2;
        else
            return (double)(element1+element2)/2.0;

        //TC:O(n+m)
        //SC:O(1)
    }

    public static double findMedianSortedArraysBS(int[] nums1, int[] nums2) {

        int n1=nums1.length, n2=nums2.length, n=n1+n2;

        if(n1>n2)
            return findMedianSortedArrays(nums2,nums1);

        int low=0, high=n1;
        int left=(n1+n2+1)/2;

        while(low<=high){

            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;

            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(n%2 == 1)
                    return Math.max(l1,l2);
                else
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2)
                high=mid1-1;
            else low=mid1+1;
        }
        return 0.0;

        //TC:log(size small array)
        //SC:O(1)
    }
}
