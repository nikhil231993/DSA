package leetcode.designPatterns.template;

public class Main {

    public static void main(String[] args) {

        Template localOrderProcessor=new LocalOrderProcessor();
        localOrderProcessor.processOrder();

        Template internationOrderProcessor=new InternationOrderProcessor();
        internationOrderProcessor.processOrder();
    }
}
