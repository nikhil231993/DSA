package leetcode.company.microsoft;

public class LCA3LC1650 {


    //Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
    //
    //Each node will have a reference to its parent node. The definition for Node is below:
    //
    //class Node {
    //    public int val;
    //    public Node left;
    //    public Node right;
    //    public Node parent;
    //}
    //According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."

    /*
    class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p==null || q==null)
            return null;
        Node l1=p;
        Node l2=q;

        while(l1!=l2){
            l1=l1.parent;
            l2=l2.parent;
            if(l1==null)
                l1=q;
            if(l2==null)
                l2=p;

        }
        return l1;
    }
}
     */
}
