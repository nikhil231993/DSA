package leetcode.linkedlist.easy;

public class LC83RemoveDuplicatesSingleLLSorted {

    /**
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            ListNode t2=temp.next;
            while(t2!=null && t2.val==temp.val){
                t2=t2.next;
            }
            temp.next=t2;
            temp=temp.next;
        }
        return head;
    }
     */
}
