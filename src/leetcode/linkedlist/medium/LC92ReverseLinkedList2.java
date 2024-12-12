package leetcode.linkedlist.medium;

public class LC92ReverseLinkedList2 {

    /**
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null || head.next==null)  return head;
        if(left==1)
            return reverse(head, right-left);

        ListNode temp=head;
        int count=1;
        ListNode prev=null;
        while(count!=left){
            prev=temp;
            temp=temp.next;
            count++;
        }

        ListNode newHead=reverse(temp, right-left);
        prev.next=newHead;
        return head;
    }

    public ListNode reverse(ListNode head, int k){

        ListNode current=head;
        ListNode next=null;
        ListNode prev=null;
        while(k>=0){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            k--;
        }
        head.next=current;
        return prev;
    }
     */
}
