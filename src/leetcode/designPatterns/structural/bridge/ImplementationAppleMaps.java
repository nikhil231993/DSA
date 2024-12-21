package leetcode.designPatterns.structural.bridge;

public class ImplementationAppleMaps implements ImplementationNavigation {

    @Override
    public void navigateTo(String destination) {
        System.out.println("Using Apple Maps");
    }
}
