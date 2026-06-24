package leetcode.company.microsoft;

public class LC362DesignHitCounter {

    //Approach 1
    /*
    class HitCounter {

        Queue<Integer> q;

        public HitCounter() {
            q=new LinkedList<>();
        }

        public void hit(int timestamp) {
            q.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while(!q.isEmpty() && q.peek()<=timestamp-300)
                q.poll();
            return q.size();
        }
    }
    */

    //Approach 2
    /*
    class Node{
        int timestamp;
        int count;
        public Node(int timestamp, int count){
            this.timestamp=timestamp;
            this.count=count;
        }
    }

    class HitCounter {

        Deque<Node> q;
        int total=0;

        public HitCounter() {
            q=new LinkedList<>();
        }

        public void hit(int timestamp) {
            if(q.isEmpty() || q.getLast().timestamp!=timestamp) //peekLast() can also be used
                q.add(new Node(timestamp, 1));
            else {
                q.getLast().count++;
            }
            total++;
        }

        public int getHits(int timestamp) {
            while(!q.isEmpty() && q.peek().timestamp<=timestamp-300){
                total-=q.peek().count;
                q.poll();
            }
            return total;
        }
    }
    */
}
