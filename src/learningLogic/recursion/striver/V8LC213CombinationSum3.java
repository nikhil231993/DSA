package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V8LC213CombinationSum3 {

    public static void main(String[] args) {
        int n=7,k=3;

        List<List<Integer>> list =new ArrayList();
        List<Integer>  arr=new ArrayList();

        combination(list,arr,n,k,1,9);
        System.out.println(list);

    }

    public static void combination(List<List<Integer>> list, List<Integer> arr, int target, int k, int index,int n1){

        if(n1-index+1<k){
            return;
        }

        if(index>10){
            return;
        }

        if(k==0 && target!=0)
            return;
        if(target==0 && k==0){
            list.add(new ArrayList<>(arr));
            return;
        }

        arr.add(index);
        combination(list,arr,target -index,k-1,index+1,n1);
        arr.remove(arr.size()-1);
        combination(list,arr,target,k,index+1,n1);
        // if(target<0){
        //     return;
        // }public

        // if(0==k && target==0){
        //         list.add(new ArrayList<>(arr));
        //         return;
        //     }

        // for(int i=index;i<=9;i++){
        //      arr.add(i);
        //     combination(list,arr,target-i,k-1,i+1,n1);
        //     arr.remove(arr.size()-1);
        // }

        //TC:O(2 raise to 9 *k(avg length od combinations))
        //SC:k*x(no of combinations)+O(n)
    }


}
