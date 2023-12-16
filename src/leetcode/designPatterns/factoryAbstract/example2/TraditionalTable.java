package leetcode.designPatterns.factoryAbstract.example2;

public class TraditionalTable implements ITable {

    @Override
    public void placeItem() {
        System.out.println("Traditional table to sit on");
    }
}
