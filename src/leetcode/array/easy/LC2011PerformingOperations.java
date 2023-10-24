package leetcode.array.easy;

public class LC2011PerformingOperations {

    public static void main(String[] args) {
        String[] operations =new String[] {"--X","X++","X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int val=0;
        for(int i=0;i<operations.length;i++){
            for(int j=0;j<operations[i].length();j++){
                if(operations[i].charAt(j)=='+'){
                    val++;
                    break;
                }
                else if(operations[i].charAt(j)=='-'){
                    val--;
                    break;
                }

            }
        }
        return val;
    }
}
