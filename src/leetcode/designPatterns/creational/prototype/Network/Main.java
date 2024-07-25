package leetcode.designPatterns.creational.prototype.Network;

public class Main {

    public static void main(String[] args) {

        NetworkDevice router1=new Router("router","tcp");
        NetworkDevice switch1=new Switch("switch","ip");

        NetworkDevice router2=router1.cloneDevice();
        NetworkDevice switch2=switch1.cloneDevice();

        NetworkDevice switch3=switch2; // when clone like this both have same instance and change in one will impact other

        router1.update("HTTP");
        System.out.println("Router 1: ");
        router1.display();
        System.out.println("Router 2: ");
        router2.display();

        switch1.update("gcp");
        switch2.update("test");

        System.out.println("Switch 1: ");
        switch1.display();
        System.out.println("Switch 2: ");
        switch2.display();
        System.out.println("Switch 3: ");
        switch3.display();// check what this displays once we update switch 2 in line 29
    }
}
