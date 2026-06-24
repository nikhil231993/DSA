
import java.util.ArrayList;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {

        int n=3;
        List<String> ans=new ArrayList<>();
        generateParenthesis(0,0,n,"", ans);
        System.out.println(ans);
    }

    private static void generateParenthesis(int open, int closed, int n, String s, List<String> ans) {

        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(open<n)
            generateParenthesis(open+1, closed,n, s+"(", ans);
        if(closed<open)
            generateParenthesis(open, closed+1, n, s+")", ans);
    }


//    public static List<Integer> func(TreeNode root){
//
//        if(root==null)
//            return new ArrayList<>();
//
//        List<Integer> list=new ArrayList<>();
//
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//
//        while(!q.isEmpty()){
//
//            int n=q.size();
//            int max=Integer.MIN_VALUE;
//            for(int i=0;i<n;i++){
//
//                TreeNode node=q.poll();
//                max=Math.max(max, node.val);
//                if(node.left!=null)
//                    q.offer(node.left);
//                if(node.right!=null)
//                    q.offer(node.right);
//        }
//            list.add(max);
//    }
//        return list;
}
