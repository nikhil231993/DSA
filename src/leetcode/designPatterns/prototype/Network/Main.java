package leetcode.designPatterns.prototype.Network;

public class Main {

    public static void main(String[] args) {
        NetworkDevice router1=new Router("router","tcp");
        NetworkDevice switch1=new Switch("switch","ip");

        NetworkDevice router2=router1.cloneDevice();
        NetworkDevice switch2=switch1.cloneDevice();

        router1.update("HTTP");
        router1.display();
        router2.display();

        switch1.update("gcp");
        switch1.display();
        switch2.display();

    }
}
