package leetcode.designPatterns.factoryAbstract.example3;

public class FileDebugLogger implements DebugLogger{
    @Override
    public void debugDisplay() {
        System.out.println("File Debug Logger");
    }
}
