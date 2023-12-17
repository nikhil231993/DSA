package leetcode.designPatterns.prototype.Network;

public class Switch extends NetworkDevice{

    private String name;

    private String protocol;

    public Switch(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    @Override
    void display() {
        System.out.println("Switch{" +
                "name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                '}');
    }

    @Override
    void update(String name) {
        this.protocol=name;
    }

    @Override
    NetworkDevice cloneDevice() {
        return new Switch(name, protocol);
    }
}
