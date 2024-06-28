package leetcode.designPatterns.factoryAbstract.example2;

public class TraditionalSofa implements ISofa {

    @Override
    public void sitOn() {
        System.out.println("Traditional sofa to sit on");
    }
}
