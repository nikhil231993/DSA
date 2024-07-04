package leetcode.designPatterns.creational.builder.example3chainingWithOutDirector;

public abstract class DesktopBuilder {

    protected Desktop desktop;

    public DesktopBuilder(){

        System.out.println("Reached here");
        this.desktop=new Desktop();
    }

    public abstract DesktopBuilder buildMonitor();

    public abstract DesktopBuilder buildKeyBoard();

    public abstract DesktopBuilder buildMouse();

    public abstract DesktopBuilder buildSpeaker();

    public abstract DesktopBuilder buildRam();

    public abstract DesktopBuilder buildProcessor();

    public abstract DesktopBuilder buildMotherboard();

    public Desktop build(){
        return this.desktop;
    }
}
