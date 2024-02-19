package leetcode.linkedlist.medium;

public class LC82EntireDuplicateRemoval {

    /**

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=head;
        ListNode prev=dummy;

        while(temp!=null && temp.next!=null){

            if(temp.val!=temp.next.val){
                prev=prev.next;;
            }else{
                while(temp.next!=null && temp.val==temp.next.val)
                    temp=temp.next;
                prev.next=temp.next;// This handles when first itslef has duplicate
            }

            temp=temp.next;
        }
        return dummy.next;
    }
     TC:O(n)
     SC:O(1)
     */
}
