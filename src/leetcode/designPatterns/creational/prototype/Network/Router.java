package leetcode.designPatterns.creational.prototype.Network;

public class Router extends NetworkDevice{

    private String name;

    private String protocol;

    public Router(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    //We can do clone like this also
    public Router(Router router) {
        this.name = router.name;
        this.protocol = router.protocol;
    }

    @Override
    public void update(String name) {
        this.protocol=name;
    }

    @Override
    public NetworkDevice cloneDevice() {
        return new Router(this);
    }

    @Override
    void display() {
        System.out.println("Router{" +
                "name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                '}');
    }
}
