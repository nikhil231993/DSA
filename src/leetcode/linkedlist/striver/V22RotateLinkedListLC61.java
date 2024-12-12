package leetcode.linkedlist.striver;

public class V22RotateLinkedListLC61 {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2};

        Node head=new Node(arr[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head, arr);
        V2DeletionAndInsertion.display(head);

        System.out.println("######## Group Reversal ############");
        int k=2;

        Node newHead=rotateRight(head, k);

        V2DeletionAndInsertion.display(newHead);
    }

    public static Node rotateRight(Node head, int k) {

        if(head==null || k==0)
            return head;

        Node tail=head;
        int count=1;
        while(tail.next!=null){
            count++;
            tail=tail.next;
        }

        if(k%count==0)
            return head;

        tail.next=head;
        k=k%2;
        int pos=count-k;

        Node first=head;
        pos--;
        while(pos>0){
            pos--;
            first=first.next;
        }

        head=first.next;
        first.next=null;

        return head;

        //TC:O(1N)
        //SC:O(1)
    }
}
