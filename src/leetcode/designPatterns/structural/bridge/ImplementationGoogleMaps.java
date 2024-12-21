package leetcode.designPatterns.structural.bridge;

public class ImplementationGoogleMaps implements ImplementationNavigation { //Implementation

    @Override
    public void navigateTo(String destination) {
        System.out.println("Using Google Maps");
    }
}
