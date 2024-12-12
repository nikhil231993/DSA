package leetcode.heap.hard;

public class LC23MergeKSortedLists {

//    public ListNode mergeKLists(ListNode[] lists) {
//
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
//
//        for(ListNode node: lists){
//            if(node!=null)
//                pq.offer(node);
//        }
//
//        ListNode dummy=new ListNode(-1);
//        ListNode temp=dummy;
//        while(!pq.isEmpty()){
//            ListNode n=pq.poll();
//            temp.next=n;
//            temp=temp.next;
//            if(n.next!=null){
//                pq.offer(n.next);
//            }
//        }
//        return dummy.next;
//    }
}
