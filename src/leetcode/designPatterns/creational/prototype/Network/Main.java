package leetcode.designPatterns.creational.prototype.Network;

public class Main {

    public static void main(String[] args) {

        NetworkDevice router1=new Router("router","tcp");
        NetworkDevice router2=router1.cloneDevice();        // value of router 2 does not change even if we change router 1 any attribute value
        NetworkDevice router3=new Router((Router) router1); // value of router 3 does not change even if we change router 1 any attribute value
        NetworkDevice router4=router1;                      // value of router 4 router as in this case same instance is modified

        NetworkDevice switch1=new Switch("switch","ip");
        NetworkDevice switch2=switch1.cloneDevice();

        NetworkDevice switch3=switch2; // when clone like this both have same instance and change in one will impact other

        router1.update("HTTP");
        System.out.println("Router 1: ");
        router1.display();
        System.out.println("Router 2: ");
        router2.display();
        System.out.println("Router 3: ");
        router3.display();
        System.out.println("Router 4: ");
        router4.display();

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
