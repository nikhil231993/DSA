package leetcode.recursion;

public class Re4ReverseArray {

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        reverseArray(arr,0,arr.length);
        for(int n:arr)
            System.out.println(n);

        System.out.println("###########");
        int[] arr1=new int[]{1,2,3,4,5};
        int start=0;
        int end= arr1.length-1;
        reverseUsingTwoPointer(arr,start,end);
        for(int n:arr1)
            System.out.println(n);
    }

    private static void reverseUsingTwoPointer(int[] arr, int start, int end) {

        if(start==end)
            return;
        reverseArray(arr,start+1,end-1);
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

    private static void reverseArray(int[] arr, int i, int length) {

        if(i==length/2){
            return;
        }
        reverseArray(arr,i+1,length);
        int temp=arr[i];
        arr[i]=arr[length-i-1];
        arr[length-i-1]=temp;
        //TC:O(N)
        //SC:O(N)

    }
}
