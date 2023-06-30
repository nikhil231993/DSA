package leetcode.array.extra;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
       int n = 4;
       int[] arr1 =new int[] {1,4,8,10};
       int m = 3;
       int[] arr2=new int[] {2,3,9};

       //Brute
      brute(n,arr1,m,arr2);
      for(int n1:arr1)
          System.out.println(n1);
        for(int n1:arr2)
            System.out.println(n1);

        System.out.println("######################");

      //optimal1
        int[] arr3 =new int[] {1,4,8,10};
        int[] arr4=new int[] {2,3,9};
      optimal1(n,arr3,m,arr4);
        for(int n1:arr3)
            System.out.println(n1);
        for(int n1:arr4)
            System.out.println(n1);

        System.out.println("######################");
        //optimal2
        int[] arr5 =new int[] {1,4,8,10};
        int[] arr6=new int[] {2,3,9};
        optimal2(n,arr5,m,arr6);
        for(int n1:arr5)
            System.out.println(n1);
        for(int n1:arr6)
            System.out.println(n1);
    }

    public static void swap(int[] arr1, int[] arr2, int left, int right){
        if(arr1[left]>arr2[right]){
            int temp=arr1[left];
            arr1[left]=arr2[right];
            arr2[right]=temp;
        }
    }

    private static void optimal2(int n, int[] arr5, int m, int[] arr6) {

        int len=n+m;
        int gap=( len / 2 )+( len % 2 );

        while(gap>0){
            int left=0;
            int right=left+gap;

            while(right<len){
                if(left<n && right>=n){
                    swap(arr5,arr6,left,right-n);
                }else if(left >=n && right>=n){
                    swap(arr6,arr6,left-n,right-n);
                }else if(left<n && right<n){
                    swap(arr5,arr5,left,right);
                }
                left++;
                right++;
            }
            if(gap==1)
                break;
            gap=(gap/2)+(gap%2);
            //TC:O(log base 2(m+n))*(m+n)
        }
    }

    private static void optimal1(int n, int[] arr3, int m, int[] arr4) {
        int left=n-1;
        int right=0;

        while(left>=0 && right<m){
            if(arr3[left]>arr4[right]){
                int temp=arr3[left];
                arr3[left]=arr4[right];
                arr4[right]=temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        //TC:O(Min(left,right))+O(nlogn)+o(mlogm)
        //SC:O(1)
    }

    private static void brute(int n, int[] arr1, int m, int[] arr2) {

        int[] res=new int[n+m];

        int left=0;
        int right=0;
        int k=0;
        while(left<n && right< m){
            if(arr1[left]<=arr2[right]){
                res[k++]=arr1[left];
                left++;
            }else{
                res[k++]=arr2[right];
                right++;
            }
        }
        while(left<n){
            res[k++]=arr1[left];
            left++;
        }
        while(right<m){
            res[k++]=arr2[right];
            right++;
        }
        for(int i=0;i<res.length;i++){
            if(i<n){
                arr1[i]=res[i];
            }else{
                arr2[i-n]=res[i];
            }
        }
        //TC:O(n+m)+O(n+m)
        //SC:O(n+m)
    }
}