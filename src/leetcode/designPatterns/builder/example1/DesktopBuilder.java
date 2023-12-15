package leetcode.designPatterns.builder.example1;

public abstract class DesktopBuilder {
    public Desktop desktop;

    public DesktopBuilder(){
        this.desktop=new Desktop();
    }

    public abstract void buildMonitor();
    public abstract void buildKeyBoard();
    public abstract void buildMouse();
    public abstract void buildSpeaker();
    public abstract void buildRam();
    public abstract void buildProcessor();
    public abstract void buildMotherboard();

    public Desktop getDesktop(){
        return this.desktop;
    }

}
