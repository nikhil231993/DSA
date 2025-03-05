package leetcode.sortingtechniques;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr=new int[]{10, 7, 100, 45, 200, 5, 1};
        int n=arr.length;
        selectionSort(arr, n);
        for(int num: arr)
            System.out.println(num);
    }

    private static void selectionSort(int[] arr, int n) {

        //We find either the smallest or largest value from the array and replace it with the first element
        //Do the above process recursively
        for(int i=0; i<n-1; i++){

            int minIndex=i;

            for(int j=i; j<n; j++){

                if(arr[j] < arr[minIndex]){
                    minIndex=j;
                }
            }

            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    //TC:O(n sqaure)
    //SC:O(1)
}
