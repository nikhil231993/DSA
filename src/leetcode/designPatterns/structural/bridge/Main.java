package leetcode.designPatterns.structural.bridge;

public class Main {

    public static void main(String[] args) {

        //We can have both NavigationSystem and NavigationImplementation as interface but
        //if we have NavigationImplementation as abstract class then we can create reference of NavigationSystem inside it

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
