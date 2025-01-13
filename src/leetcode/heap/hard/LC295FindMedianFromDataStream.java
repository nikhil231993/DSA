package leetcode.heap.hard;

import java.util.PriorityQueue;

public class LC295FindMedianFromDataStream {

    PriorityQueue<Integer> right =new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> left =new PriorityQueue<>();

    public LC295FindMedianFromDataStream() {

    }

    public void addNum(int num) {

        if(left.size() == 0){
            left.offer(num);
            return;
        }

        if(left.size()>right.size()){
            if(num > left.peek()){
                right.offer(num);
            }else{
                left.offer(num);
                right.offer(left.poll());
            }
        }else{
            if(left.peek()>num){
                left.offer(num);
            }else{
                right.offer(num);
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {

        if(left.size()==right.size())
            return (left.peek()+right.peek())/2.0;
        else
            return left.peek();
    }

    public static void main(String[] args) {

        int[] arr=new int[]{5,15,1,3};

        LC295FindMedianFromDataStream obj=new LC295FindMedianFromDataStream();
        for(int num : arr){
            obj.addNum(num);
            System.out.println(obj.findMedian());
        }
    }
}
