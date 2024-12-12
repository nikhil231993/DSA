package leetcode.heap.hard;

import java.util.PriorityQueue;

public class CodingNinjasMedianInaStream {

    public static void main(String[] args) {

        int[] arr=new int[]{1, 2, 3 };
        int[] result=findMedian(arr, arr.length);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }

    public static int[] findMedian(int[] arr, int n) {

        int[] arr1=new int[n];
        PriorityQueue<Integer> left=new PriorityQueue<>((a, b)-> b - a);
        PriorityQueue<Integer> right=new PriorityQueue();
        for(int i=0;i<n;i++){
            int median=func(arr[i], n, left, right);
            arr1[i]=median;
        }
        return arr1;
    }

    public static int func(int num, int n, PriorityQueue<Integer> left, PriorityQueue<Integer> right){

        if(left.size()==0){
            left.offer(num);
            return left.peek();
        }

        if(left.size() > right.size()){
            if(num>left.peek()){
                right.offer(num);
            }else{
                left.offer(num);
                right.offer(left.poll());
            }
        }else{
            if(num < left.peek()){
                left.offer(num);
            }else{
                right.offer(num);
                left.offer(right.poll());
            }
        }

        if(left.size()==right.size())
            return (left.peek()+right.peek())/2;
        else
            return left.peek();
    }
}
