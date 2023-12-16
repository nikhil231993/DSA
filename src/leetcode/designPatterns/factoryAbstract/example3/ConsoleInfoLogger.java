package leetcode.designPatterns.factoryAbstract.example3;

public class ConsoleInfoLogger implements InfoLogger {
    @Override
    public void infoDisplay() {
        System.out.println("Console Info Logger");
    }
}
