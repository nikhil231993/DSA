package leetcode.designPatterns.creational.factoryAbstract.example2;

public class TraditionalFurnitureFactory implements IFurnitureFactory{

    @Override
    public ISofa createSofa() {
        return new TraditionalSofa();
    }

    @Override
    public ITable createTable() {
        return new TraditionalTable();
    }

    @Override
    public IChair createChair() {
        return new TraditionalChair();
    }

    @Override
    public IAlmirah createAlmirah() {
        return new TraditionalAlmirah();
    }
}
