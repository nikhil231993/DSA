package leetcode.company.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC480SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result=medianSlidingWindow(nums, k);
        for(double num:result)
            System.out.println(num);
    }

    static PriorityQueue<Integer> left=new PriorityQueue<Integer>((a, b)-> Integer.compare(b, a));
    static PriorityQueue<Integer> right=new PriorityQueue<Integer>();
    static Map<Integer, Integer> map=new HashMap<>();
    static int leftSize=0, rightSize=0;

    public static double[] medianSlidingWindow(int[] nums, int k) {

        int idx=0;
        int n=nums.length;
        double[] result=new double[n-k+1];

        for(int i=0;i<n;i++){
            addNum(nums[i]);
            if(i>=k){
                removeNum(nums[i-k]);
            }
            if(i>=k-1){
                result[idx++]=findMedian();
            }
        }
        return result;
    }

    private static double findMedian() {
        if (leftSize == rightSize) {
            // Use 2.0 to force double division and long to prevent overflow
            return ((double)left.peek() + (double)right.peek()) / 2.0;
        }
        return (double)left.peek();
    }

    private static void removeNum(int value){
        map.put(value, map.getOrDefault(value, 0)+1);
        if(value<=left.peek()){
            leftSize--;
        }else{
            rightSize--;
        }
        prune(left);
        prune(right);
        balance();
    }

    private static void addNum(int value){
        if(left.isEmpty() || left.peek()>=value){
            left.offer(value);
            leftSize++;
        }else{
            right.offer(value);
            rightSize++;
        }
        balance();
    }
    private static void balance(){
        if(leftSize>rightSize+1){
            right.offer(left.poll());
            leftSize--;
            rightSize++;
            prune(left);
        }else if(rightSize>leftSize){
            left.offer(right.poll());
            rightSize--;
            leftSize++;
            prune(right);
        }
    }

    private static void prune(PriorityQueue<Integer> heap) {
        // Only remove if the current peek is marked for deletion in the map
        while (!heap.isEmpty() && map.getOrDefault(heap.peek(), 0) > 0) {
            int num = heap.peek();
            map.put(num, map.get(num) - 1);
            heap.poll();
        }
    }
}
