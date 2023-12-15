package leetcode.designPatterns.builder.example1;

public class HPDesktopBuilder extends DesktopBuilder{
    @Override
    public void buildMonitor() {
        this.desktop.setMonitor("HP Monitor");
    }

    @Override
    public void buildKeyBoard() {
        this.desktop.setKeyboard("HP KeyBoard");
    }

    @Override
    public void buildMouse() {
        this.desktop.setMouse("HP Mouse");
    }

    @Override
    public void buildSpeaker() {
        this.desktop.setSpeaker("HP Speaker");
    }

    @Override
    public void buildRam() {
        this.desktop.setRam("HP Ram");
    }

    @Override
    public void buildProcessor() {
        this.desktop.setProcessor("HP Processor");
    }

    @Override
    public void buildMotherboard() {
        this.desktop.setMotherboard("HP Motherboard");
    }
}
