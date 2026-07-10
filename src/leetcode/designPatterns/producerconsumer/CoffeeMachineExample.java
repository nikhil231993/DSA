package leetcode.designPatterns.producerconsumer;

public class CoffeeMachineExample{

    boolean isAvailable=false;

    public synchronized void drinkCoffee() throws InterruptedException {

        while(!isAvailable)
            wait();

        System.out.println("Drank Coffee");
        Thread.sleep(100);
        isAvailable=false;
        notify();
    }

    public synchronized void makeCoffee() throws InterruptedException {
        while(isAvailable)
            wait();
        System.out.println("Made Coffee");
        Thread.sleep(100);
        isAvailable=true;
        notify();
    }
}

class ProducerConsumerProblem {

    public static void main(String[] args) {
        CoffeeMachineExample coffeeMachine=new CoffeeMachineExample();
        new Thread(()->{
            while (true) {
                try {
                    coffeeMachine.drinkCoffee();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
            try {
                coffeeMachine.makeCoffee();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }
        }).start();
    }
}
