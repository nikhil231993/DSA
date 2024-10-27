package leetcode.designPatterns.structural.bridge;

public class ImplementationGoogleMaps implements ImplNavigation { //Implementation

    @Override
    public void navigateTo(String destination) {
        System.out.println("Using Google Maps");
    }
}
