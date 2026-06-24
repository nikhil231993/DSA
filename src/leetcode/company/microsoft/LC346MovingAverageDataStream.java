package leetcode.company.microsoft;

public class LC346MovingAverageDataStream {
    /*
    class MovingAverage {
        Queue<Integer> q;
        int maxSize;
        double runningSum;
        public MovingAverage(int size) {
            q = new LinkedList<>();
            maxSize = size;
            runningSum = 0.0;
        }

        public double next(int val) {
            if (q.size() == maxSize) {
                runningSum = runningSum - q.poll();
            }
            runningSum += val;
            q.offer(val);
            return runningSum/q.size();
        }
    }
    */

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
