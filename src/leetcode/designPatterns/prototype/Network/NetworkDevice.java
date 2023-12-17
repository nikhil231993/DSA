package leetcode.designPatterns.prototype.Network;

public abstract class NetworkDevice {

     abstract void display();

     abstract void update(String name);

     abstract NetworkDevice cloneDevice();
}
