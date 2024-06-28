package leetcode.designPatterns.factoryAbstract.example2;

public class ModernFurniture implements  IFurnitureFactory{

    @Override
    public ISofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public ITable createTable() {
        return new ModernTable();
    }

    @Override
    public IChair createChair() {
        return new ModernChair();
    }

    @Override
    public IAlmirah createAlmirah() {
        return new ModernAlmirah();
    }
}
