package leetcode.linkedlist.striver;

public class V25MergeKSortedListLC23 {

    //Approach 1:  Parse through the lists and add it in arr. Sort it and then put back in diff array

    /**
    func(List<Node> lists){
        arr=[];
        for(int i=0;i<lists.size();i++){   //K
            Node temp=lists[i];
            while(temp!=null){              //N
                arr.add(temp.val);
                temp-=temp.next;
            }
        }
        sort(arr);  //MlogM where M=KN

        head=convert(arr);  //M

        return head;
     }

     //consider each lists is of same size N
     TC:(N*K)+ MlogM+ M
     SC:O(M) array + O(M) final list
     */

    //Approach 2: Merge two lists in place and call it in loop

    /**
     func(List<Node> lists){
         head=lists[0];

         for(i=1; i<lists.size(); i++){
             head=mergeLists(head, lists[i]);
         }
         return head;
     }

     TC:
     proof: O(N1+N2)+ O(N1+N2+N3)+ O(N1+N2+N3+N$) Assume all are of same length
            O(2N)+ O(3N)+ O(4N) Adding an extra N
            O(N)+ O(2N)+ O(3N)+ O(4N) +KN
            N*K*(K+1)/2 so it is somewhere near N cube

     SC:O(1)
     */

    //Approach 3: Min Heap using PQ

    /**
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode node: lists){
            if(node!=null)
                pq.offer(node);
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode n=pq.poll();
            temp.next=n;
            temp=temp.next;
            if(n.next!=null){
                pq.offer(n.next);
            }
        }
        return dummy.next;
    }

     TC:KlogK(for loop) + KNlogK(while loop)
     SC:O(K) as heap has only at max k elements
     */
}
