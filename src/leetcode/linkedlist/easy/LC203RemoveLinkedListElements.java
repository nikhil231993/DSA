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

    //Approach 2: Self

    /**
    public ListNode removeElements(ListNode head, int val) {

        if(head==null)
            return null;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val!=val){
                prev.next=temp;
                prev=prev.next;
            }
            temp=temp.next;
        }
        prev.next=null;
        return dummy.next;
    }
     */
}
