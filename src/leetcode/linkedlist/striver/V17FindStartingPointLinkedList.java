package leetcode.linkedlist.striver;

public class V17FindStartingPointLinkedList {

    //Approach 1: Use hashing to remember the node which I have seen first previously

    //Approach 2:

    /**
    public ListNode detectCycle(ListNode head) {

        if(head ==null || head.next==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }

        if(fast==null || fast.next==null)
            return null;
        ListNode first=head;
        ListNode second=fast;

        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }
     */
}
