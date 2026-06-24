package leetcode.company.microsoft;

public class LC208ImplementTrie {

    class Node{
        Node[] links;
        boolean isEnd;
        public Node(){
            this.links=new Node[26];
            this.isEnd=false;
        }
    }

    class Trie {
        Node root;
        public Trie() {
            root=new Node();
        }

        public void insert(String word) {
            Node node=root;
            for(char c:word.toCharArray()){
                int index=c-'a';
                if(node.links[index]==null)
                    node.links[index]=new Node();
                node=node.links[index];
            }
            node.isEnd=true;
        }

        public boolean search(String word) {
            Node node=root;
            for(char c:word.toCharArray()){
                int index=c-'a';
                if(node.links[index]==null)
                    return false;
                node=node.links[index];
            }
            return node.isEnd==true;
        }

        public boolean startsWith(String prefix) {
            Node node=root;
            for(char c:prefix.toCharArray()){
                int index=c-'a';
                if(node.links[index]==null)
                    return false;
                node=node.links[index];
            }
            return true;
        }
    }

}
