package leetcode.linkedlist.striver;

public class V7Sort0s1sAnd2s {

    //Approach 1: Have 3 counters and increase counter and then replace it

    //Approach 2:
    /**
    public static Node sortList(Node head) {
        // Write your code here

        if(head==null || head.next==null)
            return head;

        Node zero =new Node(-1);
        Node one =new Node(-1);
        Node two =new Node(-1);
        Node zeroHead=zero;
        Node oneHead=one;
        Node twoHead=two;

        Node temp=head;

        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                temp=temp.next;
                zero=zero.next;
            }else if(temp.data==1){
                one.next=temp;
                temp=temp.next;
                one=one.next;
            }else{
                two.next=temp;
                temp=temp.next;
                two=two.next;
            }
        }

        if(oneHead.next==null){
            zero.next=twoHead.next;
        }else{
            zero.next=oneHead.next;
        }

        one.next=twoHead.next;
        two.next=null;

        Node newHead=zeroHead.next;
        return newHead;
    }

     TC:O(N)
     SC:O(1)
    */
}
