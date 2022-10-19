package kavya.interview;

public class LevelOrderTraversal {
    kavya.interview.Node root;
    public LevelOrderTraversal() {
        root =  null;
    }
    void printLevelOrder() {
         int h = height(root);
         for(int i=1;i<=h;i++){
             printCurrentLevel(root, i);
         }
    }

    private void printCurrentLevel(kavya.interview.Node root, int level) {
        if(root == null){
            return;
        }
        if(level==1)
            System.out.println(root.data);
        else if (level>1){
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    private int height(kavya.interview.Node root) {
        if(root == null)
            return 0;
        else {
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh>rh)
                return lh+1;
            else
                return rh+1;
        }
    }

    public static void main(String args[])
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new kavya.interview.Node(1);
        tree.root.left = new kavya.interview.Node(2);
        tree.root.right = new kavya.interview.Node(3);
        tree.root.left.left = new kavya.interview.Node(4);
        tree.root.left.right = new kavya.interview.Node(5);

        tree.printLevelOrder();
    }
}
