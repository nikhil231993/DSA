package leetcode.designPatterns.bridge;

public class GoogleMaps implements NavigationSystem{
    @Override
    public void navigate(String destination) {
        System.out.println("Using Google Maps");
    }
}
