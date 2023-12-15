package leetcode.designPatterns.builder.example1;

public class Main {

    public static void main(String[] args) {
        HPDesktopBuilder hp1=new HPDesktopBuilder();
        Director dir1=new Director(hp1);

        DellDesktopBuilder dp1=new DellDesktopBuilder();
        Director dir2=new Director(dp1);

        Desktop desktop1=dir1.BuildDesktop();
        Desktop desktop2=dir2.BuildDesktop();

        desktop1.showSpecs();
        desktop2.showSpecs();
    }
}
