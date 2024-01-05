package leetcode.designPatterns.template;

public class Main {

    public static void main(String[] args) {

        LocalOrderProcessor localOrderProcessor=new LocalOrderProcessor();
        localOrderProcessor.processOrder();

        InternationOrderProcessor internationOrderProcessor=new InternationOrderProcessor();
        internationOrderProcessor.processOrder();
    }
}
