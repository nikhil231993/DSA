package leetcode.linkedlist.striver;

public class V23MergeTwoSortedList {

    //Approach 1: Parse both LL and put the values in an array and then parse the sorted array

    //Approach 2:

    /**
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }else{
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        if(list1==null)
            temp.next=list2;
        if(list2==null)
            temp.next=list1;
        return dummy.next;
    }

     TC:O(N1+N2)
     SC:O(1)
     */

    //Approach 3:

    /**
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
     */
}
