package leetcode.linkedlist.striver;

public class V1ConvertArrayToLinkedList {

    public static void main(String[] args) {

        int[] arr=new int[]{2,1,3,8};

        Node head = new Node(arr[0]);
        convertArrayToLinkedList(head, arr);

        //Traversal of LinkedList
        Node traversal=head;
        while(traversal!=null){
            System.out.println(traversal.data);
            traversal=traversal.next;
        }

        //Length of a LinkedList
        Node length=head;
        int count=0;
        while(length!=null){
            count++;
            length=length.next;
        }
        System.out.println("Length of the Linked List is : "+ count);

        System.out.println("Search value : " + searchValue(3, head));
    }

    public static boolean searchValue(int value, Node head){

        Node temp=head;
        while(temp!=null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void convertArrayToLinkedList(Node head, int[] arr){

        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node n=new Node(arr[i]);
            temp.next=n;
            temp=temp.next; // temp=n;
        }
    }
}
