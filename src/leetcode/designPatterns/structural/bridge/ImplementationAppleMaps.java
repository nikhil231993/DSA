package leetcode.designPatterns.structural.bridge;

public class ImplementationAppleMaps implements ImplNavigation {

    @Override
    public void navigateTo(String destination) {
        System.out.println("Using Apple Maps");
    }
}
