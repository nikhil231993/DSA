package leetcode.linkedlist.striver;

public class  V26SortLinkedListLC148 {

    //Approach 1:  Take the values and put it in array and then sort and then parse and put it in new LinkedList

    //Approach 2:
    /**
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null)
            return head;
        ListNode middle=findMiddle(head);
        ListNode firstHead=head;
        ListNode secondHead=middle.next;
        middle.next=null;

        ListNode firstHand=sortList(firstHead);
        ListNode secondHand=sortList(secondHead);
        return merge(firstHand, secondHand);
    }

    public static ListNode findMiddle(ListNode head){

        if(head==null || head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head.next; // This same can be used in Palindrome question and we can use same while condition as below and don't need extra .next

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode list1, ListNode list2){

        if(list1==null)
            return list2;
        if(list2==null)
            return list2;

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        while(list1!=null){
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }
        while(list2!=null){
            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }
        return dummy.next;
    }
     TC:O(log n )(N+N/2(findMiddle))
     SC:O(1)
     */
}
