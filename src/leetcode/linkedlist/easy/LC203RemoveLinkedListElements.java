package leetcode.linkedlist.easy;

public class LC203RemoveLinkedListElements {

    /**
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while(temp!=null){
            if(temp.val==val){
                temp=temp.next;
                prev.next=null;
            }else{
                prev.next=temp;
                temp=temp.next;
                prev=prev.next;
            }
        }

        return dummy.next;

     TC:O(N)
     SC:O(1)

     */

}
