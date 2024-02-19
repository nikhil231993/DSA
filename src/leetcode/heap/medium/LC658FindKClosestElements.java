package leetcode.heap.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC658FindKClosestElements {

    public static void main(String[] args) {

       int[]  arr =new int[] {1,3,4,5,6,7,8,9,10,11,20,25};
       int k = 3, x = 7;

       //Approach 1 using heap
        System.out.println(findClosestElements(arr,k,x));

        //Approach 2 using 2 pointer
        System.out.println(findClosestElementsUsingTwoPointer(arr,k,x));

        //Approach 3 using binary search
        System.out.println(binarySearch(arr,k,x));
    }

    private static List<Integer> binarySearch(int[] arr, int k, int x) {
        //https://www.youtube.com/watch?v=o-YDQzHoaKM&ab_channel=NeetCode

        int left=0;
        int right=arr.length-k;

        while(left<right){
            int mid=left+(right-left)/2;
            if(x-arr[mid]>arr[mid+k]-x)
                left=mid+1;
            else
                right=mid;
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(arr[left+i]);
        }
        return result;
        //TC:log n
        //SC:O(1)
    }

    private static List<Integer> findClosestElementsUsingTwoPointer(int[] arr, int k, int x) {

        int left=0;
        int right=arr.length-1;
        while(right-left>=k){
            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x))//we can write anyway this line as it is abs value
                left++;
            else
                right--;
        }
        List<Integer> result=new ArrayList();
        for(int i=left;i<=right;i++)
        {
            result.add(arr[i]);
        }
        return result;
        //TC:o(n-k)
        //sc:O(1)
    }

    public static  List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Node> pq=new PriorityQueue<>(
                (a,b)->a.value==b.value?b.key-a.key : b.value-a.value);

        for(Integer n:arr){
            pq.offer(new Node(Math.abs(x-n),n));
            if(pq.size()>k)
                pq.poll();
        }
        List<Integer> result=new ArrayList();
        while(!pq.isEmpty()){
            Node n=pq.poll();
            result.add(n.key);
        }
        Collections.sort(result);
        return result;
        //TC:O(nlogk)
        //SC:o(n) in worst case
    }
}
