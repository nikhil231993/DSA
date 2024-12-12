package leetcode.array.extra;

public class gfgSecondLargest {

    public static void main(String[] args) {

        int[] arr=new int[]{12, 35, 1, 10,34, 1};
        System.out.println(getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {

        Integer max=-1, secondMax=-1;
        int n=arr.length;

        for(int i=0; i<n; i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }else if(arr[i]>secondMax && arr[i]!=max){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }
}
