package leetcode.designPatterns.builder.chainingWithOutDirector;

public class DellDesktopBuilder extends DesktopBuilder{
    @Override
    public DesktopBuilder buildMonitor() {
        this.desktop.setMonitor("Dell Monitor");
        return this;
    }

    @Override
    public DesktopBuilder buildKeyBoard() {
        this.desktop.setKeyboard("Dell KeyBoard");
        return this;
    }

    @Override
    public DesktopBuilder buildMouse() {
        this.desktop.setMouse("Dell Mouse");
        return this;
    }

    @Override
    public DesktopBuilder buildSpeaker() {
        this.desktop.setSpeaker("Dell Speaker");
        return this;
    }

    @Override
    public DesktopBuilder buildRam() {
        this.desktop.setRam("Dell Ram"); return this;
    }

    @Override
    public DesktopBuilder buildProcessor() {
        this.desktop.setProcessor("Dell Processor");
        return this;
    }

    @Override
    public DesktopBuilder buildMotherboard() {
        this.desktop.setMotherboard("Dell Motherboard");
        return this;
    }
}
