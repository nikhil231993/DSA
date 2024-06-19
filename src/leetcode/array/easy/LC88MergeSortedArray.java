package leetcode.array.easy;

public class LC88MergeSortedArray {

    public static void main(String[] args) {

        int[] arr1=new int[]{4,5,6,0,0,0};
        int[] arr2=new int[]{1,2,3};

        //Approach 1: Brute
        int[] result=withExtraSpace(arr1,arr2);
        for(int n:result)
            System.out.println(n);

        //Approach 2: Optimal in constant space
        System.out.println("#############");
        optimal(arr1,arr2);
        for(int n:arr1)
            System.out.println(n);
    }

    private static void optimal(int[] arr1, int[] arr2) {

        int n=arr1.length;
        int m=arr2.length;
        int left=m-1;
        int right=m-1;
        int k=n-1;

        while(left>=0 && right >=0){

            if(arr1[left]>arr2[right]){
                arr1[k--]=arr1[left];
                left--;
            }else{
                arr1[k--]=arr2[right];
                right--;
            }
        }

        while(left>=0){
            arr1[k--]=arr1[left];
            left--;
        }
        while(right>=0){
            arr1[k--]=arr2[right];
            right--;
        }

        //TC:O(n+m)
        //SC:O(1)
    }

    private static int[] withExtraSpace(int[] arr1, int[] arr2) {

        int n=arr1.length;
        int m=arr2.length;
        int[] r=new int[n];

        int left=0;
        int right=0;
        int index=0;

        while(left<n && right<m ){

            if(arr1[left]>=arr2[right]){
                r[index++]=arr2[right];
                right++;
            }else if(arr1[left]<arr2[right]){
                r[index++]=arr1[left];
                left++;
            }
        }

        while(left<n-m){
            r[index++]=arr1[left];
            left++;
        }

        while(right<m){
            r[index++]=arr2[right];
            right++;
        }
        return r;

        //TC:O(n+m)
        //SC:O(n+m)
    }
}
