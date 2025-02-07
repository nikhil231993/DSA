package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class V36LC297SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(Node root) {

        if(root == null)
            return "";
        Queue<Node> q=new LinkedList();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){

            Node node=q.poll();

            if(node==null){
                sb.append("n ");
                continue;
            }
            sb.append(node.data +" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();

        //TC:O(n)
        //SC:O(n)
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {

        if(data == "")
            return null;

        String[] str=data.split(" ");
        Node root=new Node(Integer.parseInt(str[0]));
        Queue<Node> q=new LinkedList();
        q.offer(root);

        for(int i=1;i<str.length;i++){
            Node parent=q.poll();
            if(!str[i].equals("n")){
                Node left=new Node(Integer.parseInt(str[i]));
                parent.left=left;
                q.offer(left);// q.offer(parent.left)
            }

            if(!str[++i].equals("n")){
                Node right=new Node(Integer.parseInt(str[i]));
                parent.right=right;
                q.offer(right); //q.offer(parent.right);
            }
        }
        return root;

        //TC:O(n)
        //SC:O(n)
    }
}
