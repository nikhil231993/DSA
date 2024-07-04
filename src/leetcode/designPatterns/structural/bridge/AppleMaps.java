package leetcode.designPatterns.structural.bridge;

public class AppleMaps implements NavigationSystem{

    @Override
    public void navigate(String destination) {
        System.out.println("Using Apple Maps");
    }
}
