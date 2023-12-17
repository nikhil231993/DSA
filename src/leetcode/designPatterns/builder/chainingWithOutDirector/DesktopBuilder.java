package leetcode.designPatterns.builder.chainingWithOutDirector;

public abstract class DesktopBuilder {
    protected Desktop desktop;

    public DesktopBuilder(){
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
