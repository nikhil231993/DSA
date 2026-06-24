package leetcode.company.microsoft;

public class DeleteGetRandomWithDuplicateLC381 {

    /*
    class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedCollection() {
        list=new ArrayList();
        map=new HashMap<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());

        Set<Integer> indexes=map.get(val);
        indexes.add(list.size());
        list.add(val);
        return true;
        }
        map.get(val).add(list.size());
        list.add(val);
        return false;
    }

    public boolean remove(int val) {

        if(!map.containsKey(val) || map.get(val).isEmpty()) return false;

        Set<Integer> indexes = map.get(val);
        int indexOfTheElement = indexes.iterator().next();
        int lastIndexOfList = list.size() - 1;

        indexes.remove(indexOfTheElement);

        if(indexOfTheElement != lastIndexOfList){
            int lastValInList = list.get(lastIndexOfList);
            list.set(indexOfTheElement, lastValInList);
            Set<Integer> set = map.get(lastValInList);
            set.remove(lastIndexOfList);
            set.add(indexOfTheElement);
        }

        list.remove(lastIndexOfList);

        if(indexes.isEmpty()){
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex=random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
     */
}
