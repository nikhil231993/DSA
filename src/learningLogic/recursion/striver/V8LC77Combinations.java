package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V8LC77Combinations {

    public static void main(String[] args) {

        int n=4,k=2;
        List<List<Integer>> list=new ArrayList();
        List<Integer> arr=new ArrayList();
        combinations(n,k, list, arr,1);
        System.out.println(list);
    }

    public static void combinations(  int n, int k,List<List<Integer>> list, List<Integer> arr,int index){
        if(n-index+1<k)
            return;

        if(k==0){
            list.add(new ArrayList<>(arr));
            return;
        }
        if(index>n){
            return;
        }

        arr.add(index);
        combinations(n,k-1,list,arr,index+1);
        arr.remove(arr.size()-1);
        combinations(n,k,list,arr,index+1);

        //SC:O(n)
        //TC:O(2 raise to N)

        // if(k==0){
        //     list.add(new ArrayList<>(arr));
        //     return;
        // }

        // for(int i=index;i<=n-k+1;i++){
        //     arr.add(i);
        //     combinations(n,k-1,list,arr,i+1);
        //     arr.remove(arr.size()-1);

        // }
        //TC:2 raise to N * t (avg length of combinations)
        //SC:2 raise to n * k + O(n) (Auxiliary space)
        //This is ans SC 2 raise to n * k
    }
}
