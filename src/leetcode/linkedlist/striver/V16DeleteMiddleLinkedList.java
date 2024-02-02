package leetcode.linkedlist.striver;

public class V16DeleteMiddleLinkedList {

    //Approach 1: Traverse and count. Again traverse till the count/2 reduces to 0

    //Approach 2:

    /**
    public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=slow.next.next;
        return head;
    }
     TC:O(N)
     SC:O(1)
     */
}
