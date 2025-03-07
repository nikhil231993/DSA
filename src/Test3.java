import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = new int[]{2,6,3,8,4,1,0};
        // non negative, unique, unsorted
        int b = 0;
        List<List<Integer>> ans= new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i  = 0; i< arr.length; i++) {
//            if (arr[i] == 0) {
//                continue;
//            }
            int val = b/arr[i];
            if (set.contains(b/arr[i]) && arr[i] * val == b ) {
                ans.add(Arrays.asList(b/arr[i], arr[i]));
            }
//            if (arr[i] ==0 && b == 0) {
//                ans.add()
//            }
            set.add(arr[i]);
        }
        System.out.println(ans);
    }
}
