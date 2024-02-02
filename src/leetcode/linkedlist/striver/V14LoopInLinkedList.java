package leetcode.linkedlist.striver;

public class V14LoopInLinkedList {

    //Approach 1:: Put each node in a hash and then keep on parsing and the moment we see same node we can say there is a loop

    //Approach 2:

    /**
    public boolean hasCycle(ListNode head) {

        if(head==null)
            return false;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
     TC: This will vary based on example
     SC:O(1 )
     */
}
