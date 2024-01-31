package leetcode.linkedlist.striver;

public class V2DeletionAndInsertion {

    public static void main(String[] args) {

        int[] arr=new int[]{2,1,3,8};

        Node head=new Node(arr[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head, arr);

        //delete head at first
        System.out.println("Delete Head : ");
        Node newHead=deleteHead(head);
        display(newHead);

        //delete Tail
        System.out.println("Delete Tail : ");
        Node headAfterTailDeletion=deleteTail(head);
        display(headAfterTailDeletion);

        //delete Kth element of the list
        System.out.println("Delete at Kth position : ");
        int[] arr1=new int[]{10,20,30,40,50};
        int k=2;
        Node head1=new Node(arr1[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head1, arr1);
        Node newHead1=deleteAtKPosition(head1,k);
        display(newHead1);

        //Remove Element with a particular value
        System.out.println("Delete a particular value : ");
        int[] arr2=new int[]{10,20,30,40,50};
        int value =40;
        Node head2=new Node(arr2[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head2, arr2);
        Node newHead2=deleteParticularValue(head2,value);
        display(newHead2);

        System.out.println("#############   INSERTION    ################");

        System.out.println("Insert at Head : ");
        int[] arr3=new int[]{10,20,30,40,50};
        int value3 =5;
        Node head3=new Node(arr3[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head3, arr3);
        Node newHead3=insertAtHead(head3, value3);
        display(newHead3);

        System.out.println("Insert at Last : ");
        int[] arr4=new int[]{10,20,30,40,50};
        int value4 =500;
        Node head4=new Node(arr4[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head4, arr4);
        Node newHead4=insertAtTail(head4, value4);
        display(newHead4);

        System.out.println("Insert at a particular position : ");
        int[] arr5=new int[]{10,20,30,40,50};
        int value5 =25;
        int pos=4;
        Node head5=new Node(arr5[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head5, arr5);
        Node newHead5=insertAtParticularPosition(head5, value5,pos);
        display(newHead5);

        System.out.println("Insert before a particular value : ");
        int[] arr6=new int[]{10,20,30,40,50};
        int value6 =31;
        int before=50;
        Node head6=new Node(arr6[0]);
        V1ConvertArrayToLinkedList.convertArrayToLinkedList(head6, arr6);
        Node newHead6=insertBeforeParticularValue(head6, value6, before);
        display(newHead6);
    }

    private static Node insertBeforeParticularValue(Node head, int value, int before) {

        if(head==null){
            System.out.println("Not possible");
            return null;
        }
        if(head.data==before){
            Node n=new Node(value);
            n.next=head;
            head=n;
            return head;
        }
        boolean found=false;
        Node temp=head;
        while(temp!=null){
            if(temp.next.data==before){
                Node n= new Node(value);
                n.next=temp.next;
                temp.next=n;
                found=true;
                break;
            }
            temp=temp.next;
        }

        if(!found){
            System.out.println("Not found");
            return null;
        }

        return head;
    }

    private static Node insertAtParticularPosition(Node head, int value, int k) {

        if(head==null){
            if(k==1){
                return new Node(value);
            }else{
                System.out.println("Not possible this combination");
            }
        }
        if(k==1){
            Node n=new Node(value);
            n.next=head;
            head=n;
            return head;
        }
        //At any other position
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k-1){
                Node n =new Node(value);
                n.next=temp.next;
                temp.next=n;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    private static Node insertAtTail(Node head, int value) {

        if(head==null)
            return new Node(value);
        Node temp=head;
        Node n=new Node(value);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        return head;
    }

    private static Node insertAtHead(Node head, int value3) {

        if(head==null){
            head=new Node(value3);
        }
        Node n=new Node(value3);
        n.next=head;
        //head=n If we use this then return head else n
        return n;
    }

    private static Node deleteParticularValue(Node head, int value) {

        if(head==null)
            return null;
        if(head.data==value){
            Node temp=head;
            head=head.next;
            return head;
        }

        Node temp=head;
        Node prev=null;
        while(temp!=null){
            if(temp.data==value){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    private static Node deleteAtKPosition(Node head, int k) {

        if(head==null)
            return null;
        if(k==1){
            Node temp=head; //Not necessary
            head=head.next;
            return head;
        }

        int count=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            count++;
            if(count==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    private static Node deleteTail(Node head) {

        if(head==null || head.next==null)
            return null;

        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    private static Node deleteHead(Node head) {

        if(head==null)
            return null;
        Node temp=head; //This is not needed in java as in C++ we need to delete the temp for clearing the memory.
                        // In java garbage collector does by itself
        head=head.next;
        return head;
    }

    public static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
