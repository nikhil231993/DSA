package leetcode.designPatterns.prototype.Network;

public class Main {

    public static void main(String[] args) {

        NetworkDevice router1=new Router("router","tcp");
        NetworkDevice switch1=new Switch("switch","ip");

        NetworkDevice router2=router1.cloneDevice();
        NetworkDevice switch2=switch1.cloneDevice();

        NetworkDevice switch3=switch2; // when clone like this both have same instance and change in one will impact other

        router1.update("HTTP");
        router1.display();
        router2.display();

        switch1.update("gcp");
        switch2.update("test");
        switch1.display();
        switch2.display();
        switch3.display();// check what this displays once we update switch 2 in line 29
    }
}
