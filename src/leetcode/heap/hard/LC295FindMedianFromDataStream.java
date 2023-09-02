package leetcode.heap.hard;

import java.util.PriorityQueue;

public class LC295FindMedianFromDataStream {

    PriorityQueue<Integer> smaller =new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> larger =new PriorityQueue<>();

    public LC295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if(smaller.size()==0){
            smaller.offer(num);
            return;
        }

        if(smaller.size()>larger.size()){
            if(num < smaller.peek()){
                smaller.offer(num);
                larger.offer(smaller.poll());
            }else{
                larger.offer(num);
            }
        }else{
            if(smaller.peek()<num){
                larger.offer(num);
                smaller.offer(larger.poll());
            }else{
                smaller.offer(num);
            }
        }
    }

    public double findMedian() {

        if(smaller.size()==larger.size())
            return (smaller.peek()+larger.peek())/2.0;
        else
            return smaller.peek();

    }

    public static void main(String[] args) {
        int n=4;
        int[] arr=new int[]{5,15,1,3};

        LC295FindMedianFromDataStream obj=new LC295FindMedianFromDataStream();
        for(int num:arr){
            obj.addNum(num);
            System.out.println(obj.findMedian());
        }
    }
}
