package leetcode.linkedlist.striver;

public class V28DesignBrowserHistoryLC1472 {

    /**
    public class Node{
        String data;
        Node next;
        Node prev;

        public Node(String data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    class BrowserHistory {

        Node curr=null;
        public BrowserHistory(String homepage) {
            curr=new Node(homepage);
        }

        public void visit(String url) {
            Node n=new Node(url);
            curr.next=n;
            n.prev=curr;
            curr=n;

        TC:O(1)
        }

        public String back(int steps) {
            while(steps!=0){
                if(curr.prev==null)
                    return curr.data;
                else
                    curr=curr.prev;
                steps--;
            }
            return curr.data;

        TC:O(steps)
        }

        public String forward(int steps) {
            while(steps!=0){
                if(curr.next==null)
                    return curr.data;
                else
                    curr=curr.next;
                steps--;
            }
            return curr.data;
        TC:O(steps)
        }
    }

     */
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
