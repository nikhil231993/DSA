package leetcode.linkedlist.striver;

public class V16DeleteMiddleLinkedListLC2095 {

    //Approach 1: Traverse and count. Again traverse till the count/2 reduces to 0

    //Approach 2: Here we do slight changes in Tortoise and Hare Algo where fast pointer takes one extra step

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

    //Approach 3: Best Approach

    /**
     public ListNode deleteMiddle(ListNode head) {

     if(head==null || head.next==null)
     return null;

     ListNode slow=head;
     ListNode fast=head;
     ListNode prev=null;
     while(fast!=null && fast.next!=null){
     prev=slow;
     slow=slow.next;
     fast=fast.next.next;
     }
     prev.next=prev.next.next;
     return head;
     }
     */
}
