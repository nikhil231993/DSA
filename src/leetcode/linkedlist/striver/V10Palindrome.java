package leetcode.linkedlist.striver;

public class V10Palindrome {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,2,1};

        Node head=new Node(arr[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head, arr);
        V2DeletionAndInsertion.display(head);

        //Approach 1 : Put the values in stack and while retrieving compare the values

        //Approach 2:

        System.out.println(palindrome(head));
    }

    private static boolean palindrome(Node head) {

        if(head==null || head.next==null)
            return true;

        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node newHead=reverseHead(slow.next);

        Node first=head;
        Node second=newHead;

        while(second!=null){
            if(first.data!=second.data){
                reverseHead(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }

        reverseHead(newHead);
        return true;
    }

    public static Node reverseHead(Node head) {
        if(head==null || head.next== null)
            return head;

        Node newHead=reverseHead(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
