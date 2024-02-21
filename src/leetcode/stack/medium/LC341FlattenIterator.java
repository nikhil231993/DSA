package leetcode.stack.medium;

public class LC341FlattenIterator {

    /**
    private List<Integer> fList =null;
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        fList = new ArrayList<>();
        flattening(nestedList);
        it = fList.iterator();
    }

    public void flattening(List<NestedInteger> nestedList){

        for(NestedInteger currEl : nestedList){
            if(currEl.isInteger()){
                fList.add(currEl.getInteger());
            } else {
                flattening(currEl.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(it.hasNext()){
            return it.next();
        } else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
    */
}
