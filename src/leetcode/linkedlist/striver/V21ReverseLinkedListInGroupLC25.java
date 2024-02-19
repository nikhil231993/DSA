package leetcode.linkedlist.striver;

public class V21ReverseLinkedListInGroupLC25 {

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};

        Node head=new Node(arr[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head, arr);
        V2DeletionAndInsertion.display(head);

        System.out.println("######## Group Reversal ############");
        int k=3;
        Node newHead=reverseGroup(head, k);

        V2DeletionAndInsertion.display(newHead);
    }

    private static Node reverseGroup(Node head, int k) {

        Node temp=head;
        Node prevNode=null;
        while(temp!=null){
            Node KNode=findKNode(temp, k);
            if(KNode==null){
                if(prevNode!=null)
                    prevNode.next=temp;
                break;
            }

            Node nextNode=KNode.next;
            KNode.next=null;
            reverse(temp);

            if(temp==head){
                head=KNode;
            }else{
                prevNode.next=KNode;
            }

            prevNode=temp;
            temp=nextNode;
        }
        return head;

        //TC:O(N)+O(N)
        //SC:O(1) no extra space
    }

    private static Node reverse(Node head) {
        if(head==null || head.next==null)
            return head;
        Node newHead=reverse(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    private static Node findKNode(Node temp, int k) {
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}
