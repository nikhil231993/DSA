package leetcode.linkedlist.striver;

public class V8RemoveNthNodeFromEndLC19 {

    //Approach 1: Have one pass and count no of elements and then res=count-n and then delete the element after it
    // TC:O(len)+O(len-N)

    //Approach 2: Here fast pointer moves the no of Nth node and if it reaches null that means we have to delete head

    /**
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
            if(fast==null)
                return head.next;
        }

        ListNode slow=head;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;

        return head;

    }
     TC:O(len)
     SC:O(1)
     */
}
