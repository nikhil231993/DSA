package src.leetcode.stack.medium;

public class LC1019NextGreaterNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Map<ListNode, ListNode> map = new HashMap();

            Stack<ListNode> st=new Stack();

            ListNode temp=head;
            int count=0;
            while(temp!=null){
                while(!st.isEmpty() && st.peek().val<temp.val){
                    map.put(st.pop(), temp);
                }
                st.push(temp);
                temp=temp.next;
                count++;
            }

            int[] result=new int[count];
            ListNode temp2=head;
            int i=0;
            while(temp2!=null){
                if(map.containsKey(temp2))
                    result[i]=map.get(temp2).val;
                temp2=temp2.next;
                i++;
            }
            return result;
        }
    }
    */
}
