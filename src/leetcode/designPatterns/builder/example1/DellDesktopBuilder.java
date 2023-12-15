package leetcode.designPatterns.builder.example1;

public class DellDesktopBuilder extends DesktopBuilder{
    @Override
    public void buildMonitor() {
        this.desktop.setMonitor("Dell Monitor");
    }

    @Override
    public void buildKeyBoard() {
        this.desktop.setKeyboard("Dell KeyBoard");
    }

    @Override
    public void buildMouse() {
        this.desktop.setMouse("Dell Mouse");
    }

    @Override
    public void buildSpeaker() {
        this.desktop.setSpeaker("Dell Speaker");
    }

    @Override
    public void buildRam() {
        this.desktop.setRam("Dell Ram");
    }

    @Override
    public void buildProcessor() {
        this.desktop.setProcessor("Dell Processor");
    }

    @Override
    public void buildMotherboard() {
        this.desktop.setMotherboard("Dell Motherboard");
    }
}
