package leetcode.designPatterns.creational.factoryAbstract.example3;

public class FileErrorLogger implements ErrorLogger{

    @Override
    public void errorDisplay() {
        System.out.println("FIle Error Logger");
    }
}
