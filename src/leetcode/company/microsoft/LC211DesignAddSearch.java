package leetcode.company.microsoft;

public class LC211DesignAddSearch {

    /*
    class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children=new TrieNode[26];
        isWord=false;
    }
}

class WordDictionary {

    TrieNode root=new TrieNode();
    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(node.children[index]==null)
                node.children[index]=new TrieNode();
            node=node.children[index];
        }
        node.isWord=true;
    }

    public boolean search(String word) {
        TrieNode node=root;
        return dfs(0, node, word);
    }

    private static boolean dfs(int index, TrieNode node, String word){
        if(node==null) return false;
        if(index==word.length()) return node.isWord;
        char c=word.charAt(index);
        if(c=='.'){
            for(TrieNode child:node.children){
                if(dfs(index+1, child, word))
                    return true;
            }
            return false;
        }else{
            int hash=c-'a';
            return dfs(index+1, node.children[hash], word);
        }
    }
}
    */
}
