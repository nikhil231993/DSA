package leetcode.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LC212WordSearch2 {

    public static void main(String[] args) {
        char[][] board=new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] word={"oath","pea","eat","rain"};
        System.out.println(findWords(board,word));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ans =new ArrayList();
        int n=board.length;
        int m=board[0].length;
        for(int k=0;k<words.length;k++){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==words[k].charAt(0))
                        if(search(board, i,j,n,m,words[k],0)){
                            if(!ans.contains(words[k]))
                                ans.add(words[k]);
                        }
                }
            }
        }

        return ans;
    }

    public static boolean search(char[][] board, int i, int j, int n, int m, String word, int k){
        if(k==word.length())
            return true;
        if(i<0 || i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(k))
            return false;
        char c=board[i][j];
        board[i][j]='#';
        boolean op1=search(board, i+1,j,n,m,word,k+1);
        boolean op2=search(board, i,j+1,n,m,word,k+1);
        boolean op3=search(board, i-1,j,n,m,word,k+1);
        boolean op4=search(board, i,j-1,n,m,word,k+1);
        board[i][j]=c;
        return op1||op2||op3||op4;
        //SC:O(k) that is the word length which will there in stack
        //TC:O(n*m * 4 raised to k)
    }
}
