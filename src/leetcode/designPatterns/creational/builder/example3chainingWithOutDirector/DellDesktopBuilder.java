package leetcode.designPatterns.creational.builder.example3chainingWithOutDirector;

public class  DellDesktopBuilder extends DesktopBuilder{

    @Override
    public DellDesktopBuilder buildMonitor() {
        this.desktop.setMonitor("Dell Monitor");
        return this;
    }

    @Override
    public DellDesktopBuilder buildKeyBoard() {
        this.desktop.setKeyboard("Dell KeyBoard");
        return this;
    }

    @Override
    public DellDesktopBuilder buildMouse() {
        this.desktop.setMouse("Dell Mouse");
        return this;
    }

    @Override
    public DellDesktopBuilder buildSpeaker() {
        this.desktop.setSpeaker("Dell Speaker");
        return this;
    }

    @Override
    public DellDesktopBuilder buildRam() {
        this.desktop.setRam("Dell Ram"); return this;
    }

    @Override
    public DellDesktopBuilder buildProcessor() {
        this.desktop.setProcessor("Dell Processor");
        return this;
    }

    @Override
    public DellDesktopBuilder buildMotherboard() {
        this.desktop.setMotherboard("Dell Motherboard");
        return this;
    }
}
