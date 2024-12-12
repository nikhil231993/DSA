package leetcode.linkedlist.striver;

public class V27CloneLLWithRandomPointerLC138 {

    // Approach 1: Create new nodes and stores them in hashmap. Again parse and fetch the nodes by using map.get()

    /**
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new LinkedHashMap<>();
        Node temp=head;

        while(temp!=null){

            Node n=new Node(temp.val);
            map.put(temp, n);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){

            Node copyNode=map.get(temp);
            copyNode.next=map.get(temp.next);
            copyNode.random=map.get(temp.random);

            temp=temp.next;
        }
        return map.get(head);
    }
     TC:O(2N)
     SC:O(N)+O(N)
     */

    //Approach 2:

    /**
    public Node copyRandomList(Node head) {
        createCopy(head);
        addRandomPointer(head);
        return removeOldListLinkage(head);
    }

    public static void createCopy(Node head){

        Node temp=head;

        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;

            temp=temp.next.next;
        }
    }

    public static void addRandomPointer(Node head){

        Node temp=head;

        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random!=null)
                copyNode.random=temp.random.next;
            else
                copyNode.random=null;// not necessary as constructor handles this
            temp=temp.next.next;
        }
    }

    public static Node removeOldListLinkage(Node head){

        Node dummyNode=new Node(-1);
        Node res=dummyNode;

        Node temp=head;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;

            res=res.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }

    TC:O(N)+O(N)+O(N)
     SC:O(N)
        */
}
