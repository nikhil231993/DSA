package leetcode.designPatterns.prototype.Network;

public class Switch extends NetworkDevice{

    private String name;

    private String protocol;

    public Switch(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
    }


    @Override
    public void update(String name) {
        this.protocol=name;
    }

    @Override
    public NetworkDevice cloneDevice() {
        return new Switch(name, protocol);
    }

    @Override
    void display() {
        System.out.println("Switch{" +
                "name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                '}');
    }
}
