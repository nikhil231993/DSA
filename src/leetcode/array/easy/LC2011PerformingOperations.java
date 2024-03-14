package leetcode.array.easy;

public class LC2011PerformingOperations {

    public static void main(String[] args) {
        
        String[] operations =new String[] {"--X","X++","X++"};
        
        //Approach 1: Brute force
        System.out.println(finalValueAfterOperations(operations));

        //Approach 2: Better
        System.out.println(finalValueAfterOperationsBetter(operations));

        //Approach 3: Optimal
        // https://leetcode.com/problems/final-value-of-variable-after-performing-operations/discuss/3137715/Optimized-Solution-100-Beats
        //ASCII of '+' is 43 and '-' is 45
        System.out.println(finalValueAfterOperationsOptimal(operations));
    }

    private static int finalValueAfterOperationsBetter(String[] operations) {

        int n=operations.length;
        int count=0;
        for(int i=0; i<n; i++){
            if(operations[i].charAt(0)=='+' || operations[i].charAt(2)=='+')
                count++;
            else
                count--;
        }
        return count;

        //TC:O(n)
        //SC:O(1)
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

        //TC:O(n*3)
        //SC:O(1)
    }

    public static int finalValueAfterOperationsOptimal(String[] operations) {

        int x = 0;
        for(String o : operations) x += (44 - o.charAt(1));
        return x;

        //TC:O(n)
        //SC:O(1)
    }
}
