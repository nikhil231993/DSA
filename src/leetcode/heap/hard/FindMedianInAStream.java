package leetcode.heap.hard;

import java.util.PriorityQueue;

public class FindMedianInAStream {

    static PriorityQueue<Integer> smaller=new PriorityQueue<>((a, b)->b-a);
    static PriorityQueue<Integer> larger=new PriorityQueue<>();

    //Function to insert heap.
    public static void insertHeap(int x) {

        if(smaller.size()==0) {
            smaller.offer(x);
            return;
        }
        if(smaller.size()>larger.size()){
            if(x<smaller.peek()){
                smaller.offer(x);
                larger.offer(smaller.poll());
            }else{
                larger.offer(x);
            }
        }else{
            if(x>smaller.peek()){
                larger.offer(x);
                smaller.offer(larger.poll());
            }else{
                smaller.offer(x);
            }
        }
    }

    //Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here
    }

    //Function to return Median.
    public static int getMedian() {
        if(smaller.size()==larger.size())
            return (smaller.peek()+larger.peek())/2;
        else
            return smaller.peek();
    }

    public static void main(String[] args) {
        int n=4;
        int[] arr=new int[]{5,15,1,3};
        for(int num:arr){
            insertHeap(num);
            System.out.println(getMedian());
        }
        //TC:o(nlogn)
        //SC:o(n)
    }
}
