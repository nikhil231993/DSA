package leetcode.sortingtechniques;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr=new int[]{ 23, 1 ,10, 5, 2};
        int n=arr.length;
        selectionSort(arr, n);

        for(int num : arr)
            System.out.println(num);
    }

    public static void selectionSort(int[] arr , int n){

        for(int i=1; i<n; i++){

            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
