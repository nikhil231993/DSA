package leetcode.designPatterns.creational.builder.example3chainingWithOutDirector;

public class HPDesktopBuilder extends DesktopBuilder{

    @Override
    public DesktopBuilder buildMonitor() {
        this.desktop.setMonitor("HP Monitor");
        return this;
    }

    @Override
    public DesktopBuilder buildKeyBoard() {
        this.desktop.setKeyboard("HP KeyBoard");
        return this;
    }

    @Override
    public DesktopBuilder buildMouse() {
        this.desktop.setMouse("HP Mouse");
        return this;
    }

    @Override
    public DesktopBuilder buildSpeaker() {
        this.desktop.setSpeaker("HP Speaker");
        return this;
    }

    @Override
    public DesktopBuilder buildRam() {
        this.desktop.setRam("HP Ram");
        return this;
    }

    @Override
    public DesktopBuilder buildProcessor() {
        this.desktop.setProcessor("HP Processor");
        return this;
    }

    @Override
    public DesktopBuilder buildMotherboard() {
        this.desktop.setMotherboard("HP Motherboard");
        return this;
    }
}
