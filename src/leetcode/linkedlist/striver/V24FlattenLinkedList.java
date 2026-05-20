package leetcode.linkedlist.striver;

public class V24FlattenLinkedList {

    //Approach 1: Parse through all the nodes and put the values in a list and then sort it and then put the values in a LinkedList
    //TC:O(n log n)
    //SC:O(n)

    /**
    arr=[]; temp=head;
    while(temp!=null){
        t2=temp;
        while(t2!=null){
            arr.add(t2.val);
            t2=t2.child;
        }
        temp=temp.next
    }
    sort(arr);
    convertToLinkedList(arr)

        convertToLinkedList(arr){
        if(arr.size()==0)
            return null;
        Node n=new Node(arr[0]);
        for(i=1->n){
            newNode=new Node(arr[i]);
            temp.child=newNode;
            temp=temp.child;
            }
        }
     return head;

     TC:O(N*M)+O(N*M log N*M)
     SC:O(N*M)*2;
     */

    //Approach 2:

    /**
    Node flatten(Node root)
    {
        if(root==null || root.next==null)
            return root;
        Node mergedNode= flatten(root.next);
        return merge(root, mergedNode);
    }

    public static Node merge(Node node1, Node node2){

        Node dummy=new Node(-1);
        Node temp=dummy;

        while(node1!=null && node2!=null){
            if(node1.data<=node2.data){
                temp.bottom=node1;
                node1=node1.bottom;
            }else{
                temp.bottom=node2;
                node2=node2.bottom;
            }
            temp=temp.bottom;
        }

        if(node1==null)
            temp.bottom=node2;
        if(node2==null)
            temp.bottom=node1;

        return dummy.bottom;
    }

     TC:(N * O(M+M)) Horizontal node = N Vertical = M
     SC:O(recursive stack space)
    */

    /**
    public Node flatten(Node root) {
        if(root==null || root.next==null)
            return root;
        Node nextRoot=flatten(root.next);
        return merge(root, nextRoot);
    }

    private static Node merge(Node list1, Node list2){

        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                temp.bottom=list1;
                temp=temp.bottom;
                list1=list1.bottom;
            }else{
                temp.bottom=list2;
                temp=temp.bottom;
                list2=list2.bottom;
            }
        }
        if(list1!=null)
            temp.bottom=list1;
        if(list2!=null)
            temp.bottom=list2;
        return dummy.bottom;
    }
    */
}
