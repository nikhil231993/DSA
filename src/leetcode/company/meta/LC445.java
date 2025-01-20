package leetcode.company.meta;

public class LC445 {

//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//            if(l1==null)
//                return l2;
//
//            if(l2==null)
//                return l1;
//            ListNode l1Head=reverse(l1);
//            ListNode l2Head=reverse(l2);
//            ListNode dummy=new ListNode(-1);
//            ListNode temp=dummy;
//            int sum=0, carry=0;
//            while(l1Head!=null || l2Head!=null){
//                sum=carry;
//                if(l1Head!=null){
//                    sum+=l1Head.val;
//                    l1Head=l1Head.next;
//                }
//                if(l2Head!=null){
//                    sum+=l2Head.val;
//                    l2Head=l2Head.next;
//                }
//
//                ListNode node=new ListNode(sum%10);
//                temp.next=node;
//                temp=node;
//                carry=sum/10;
//            }
//            if(carry!=0){
//                ListNode node=new ListNode(carry);
//                temp.next=node;
//                temp=node;
//            }
//            ListNode resultHead=reverse(dummy.next);
//            return resultHead;
//        }
//
//        public static ListNode reverse(ListNode head){
//
//            if(head==null || head.next==null)
//                return head;
//            ListNode newHead=reverse(head.next);
//            ListNode frontHead=head.next;
//            frontHead.next=head;
//            head.next=null;
//            return newHead;
//        }
}
