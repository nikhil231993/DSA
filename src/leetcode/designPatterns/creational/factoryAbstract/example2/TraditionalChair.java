package leetcode.designPatterns.creational.factoryAbstract.example2;

public class TraditionalChair implements IChair {

    @Override
    public void sitOn() {
        System.out.println("Traditional chair to sit on");
    }
}
