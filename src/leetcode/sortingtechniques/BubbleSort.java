package leetcode.sortingtechniques;

public class BubbleSort {

    public static void main(String[] args) {
        
        int[] arr=new int[]{100, 6, 800, 4, 2, 200, 1};
        arr=new int[]{ 1, 2, 3 ,4 ,5};
        int n=arr.length;;
        bubbleSort(arr, n);
        
        for(int num:arr)
            System.out.println(num);
    }

    private static void bubbleSort(int[] arr, int n) {

        for(int i=0; i<n-1; i++){
            boolean swapped=false;

            for(int j=0; j<n-i-1; j++){

                if(arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) {
                System.out.println("The order of the elements is already sorted");
                break;
            }
        }
    }
}
