package leetcode.designPatterns.bridge;

public class Main {

    public static void main(String[] args) {
        UberRides uberRides=new UberRides("Raj");
        UberEats uberEats=new UberEats("Daily");

        AppleMaps appleMaps=new AppleMaps();
        GoogleMaps googleMaps=new GoogleMaps();

        uberRides.setNavigationImplementation(appleMaps);
        uberRides.navigateTo("Delhi");

        uberEats.setNavigationSystem(googleMaps);
        uberEats.navigateTo("Mumbai");
    }
}
