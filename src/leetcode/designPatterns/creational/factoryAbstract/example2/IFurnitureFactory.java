package leetcode.designPatterns.creational.factoryAbstract.example2;

public interface IFurnitureFactory {

    ISofa createSofa();

    ITable createTable();

    IChair createChair();

    IAlmirah createAlmirah();
}
