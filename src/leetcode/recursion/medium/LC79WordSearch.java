package leetcode.recursion.medium;

public class LC79WordSearch {
    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))
                    if(search(board, i,j,n,m,word,0))
                        return true;
            }
        }
        return false;
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
