package leetcode.linkedlist.striver;

public class V11AddOneToLL {

    public static void main(String[] args) {

        int[] arr=new int[]{1,9,9,9,9};

        Node head=new Node(arr[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head, arr);
        V2DeletionAndInsertion.display(head);

        //Approach 1
        Node resultHead=firstApproach(head);
        System.out.println("##################### Result #########");
        V2DeletionAndInsertion.display(resultHead);

        System.out.println("########### APPROACH 2 ############");

        //Approach 2
        int[] arr1=new int[]{1,2,9};

        Node head1=new Node(arr1[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head1, arr1);
        V2DeletionAndInsertion.display(head1);

        Node resultHead1=secondApproach(head1);
        System.out.println("##################### Result #########");
        V2DeletionAndInsertion.display(resultHead1);

    }

    private static Node secondApproach(Node head) {
        int carry=helper(head);
        if(carry==1){
            Node n= new Node(1);
            n.next=head;
            return n;
        }
        return head;
    }

    private static int helper(Node head) {

        if(head==null)
            return 1;

        int carry=helper(head.next);
        head.data= head.data+carry;
        if(head.data<10)
            return 0;
        head.data=0;
        return 1;

        //TC:O(N)
        //SC:O(N)
    }

    private static Node firstApproach(Node head){

        head=V10Palindrome.reverseHead(head);

        Node temp=head;
        int carry=1;
        while(temp!=null){
            temp.data=temp.data+carry;
            if(temp.data>9){
                temp.data=temp.data%10;
                carry=1;
                temp=temp.next;
            }else{
                return V10Palindrome.reverseHead(head);
            }
        }
        if(carry==1){
            Node n=new Node(carry);
            head=V10Palindrome.reverseHead(head);
            n.next=head;
            return n;
        }
        return null;
        //TC:O(3N)
        //SC:O(N) stack i.e two times
    }
}
