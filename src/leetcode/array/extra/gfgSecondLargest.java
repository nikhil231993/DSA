package leetcode.array.extra;

public class gfgSecondLargest {

    public static void main(String[] args) {

        //Brute is sort the array and parse it from n-2 till 0 and compare each of the element with last one TC:O(NlogN) and SC:O(1) if we are sorting in place else O(N) if we are using extra array for sorting
        //Better is to traverse one time and find largest and then parse again and find second largest TC:O(2N) and SC:O(1)

        //Optimal is to traverse one time and find largest and second largest at the same time
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
            }else if(arr[i] > secondMax && arr[i]<max){
                secondMax=arr[i];
            }
        }
        return secondMax;

        //TC:O(N)
        //SC:O(N)
    }
}
