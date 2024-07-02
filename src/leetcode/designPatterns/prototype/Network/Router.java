package leetcode.designPatterns.prototype.Network;

public class Router extends NetworkDevice{

    private String name;

    private String protocol;

    public Router(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
    }


    @Override
    public void update(String name) {
        this.protocol=name;
    }

    @Override
    public NetworkDevice cloneDevice() {
        return new Router(name, protocol);
    }

    @Override
    void display() {
        System.out.println("Router{" +
                "name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                '}');
    }
}
