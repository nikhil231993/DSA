package leetcode.designPatterns.creational.builder.example3chainingWithOutDirector;

public class Main {
    //chaining without Director
    public static void main(String[] args) {

        //This is chaining
        HPDesktopBuilder hp1=new HPDesktopBuilder();

        DellDesktopBuilder dp1=new DellDesktopBuilder();

        Desktop dpDesktop= dp1.buildKeyBoard().buildMonitor().build();
        Desktop hpDesktop= hp1.buildKeyBoard().buildMonitor().buildMotherboard().build();
        dpDesktop.showSpecs();
        hpDesktop.showSpecs();
    }
}
