package leetcode.designPatterns.builder.example1;

public class Director {

    private DesktopBuilder desktopBuilder;

    public Director(DesktopBuilder pdesktopBuilder){
        this.desktopBuilder=pdesktopBuilder;
    }

    public Desktop BuildDesktop(){
        this.desktopBuilder.buildMonitor();
        this.desktopBuilder.buildMouse();
        this.desktopBuilder.buildRam();;
        this.desktopBuilder.buildProcessor();
        this.desktopBuilder.buildKeyBoard();
        this.desktopBuilder.buildSpeaker();;
        this.desktopBuilder.buildMotherboard();;
        return this.desktopBuilder.getDesktop();
    }
}
