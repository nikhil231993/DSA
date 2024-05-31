package leetcode.math.medium;

class ListNode {
      int val;

      ListNode next;

      ListNode() {}

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
 }
public class LC2AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode n=addTwoNumbers(l1,l2);
        while(n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum=0;
        int carry=0;
        ListNode l=new ListNode(-1);
        ListNode temp=l;

        while(l1!=null || l2!=null){

            sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            ListNode n=new ListNode(sum%10);
            carry=sum/10;
            temp.next=n;
            temp=temp.next;
        }

        if(carry!=0){
            ListNode n1=new ListNode(carry);
            temp.next=n1;
        }
        return l.next;

        //TC:O(n) where n is the length of the largest LinekdList
        //SC:O(n) length of the new LinkedList
    }
}
