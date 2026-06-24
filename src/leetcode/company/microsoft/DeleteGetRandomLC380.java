package leetcode.company.microsoft;

import java.util.*;

public class DeleteGetRandomLC380 {

    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;
        public RandomizedSet() {
            list=new ArrayList<>();
            map=new HashMap<>();
            random=new Random();
        }

        public boolean insert(int val) {
            if(!map.containsKey(val)){
                list.add(val);
                map.put(val, list.size()-1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if(map.containsKey(val)){
                int pos=map.get(val);
                if(pos!=list.size()-1){
                    int lastElement=list.get(list.size()-1);
                    list.set(pos, lastElement);
                    map.put(lastElement, pos);
                }

                map.remove(val);
                list.remove(list.size()-1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int pos=random.nextInt(list.size());
            return list.get(pos);
        }
    }
}
