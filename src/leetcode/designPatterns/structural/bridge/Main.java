package leetcode.designPatterns.structural.bridge;

public class Main {

    public static void main(String[] args) {

        //We can have both NavigationSystem and NavigationImplementation as interface but
        //if we have NavigationSystem as abstract class then we can create reference of ImplNavigation inside it

        NavigationSystem uberRides=new UberRides("Raj");
        NavigationSystem uberEats=new UberEats("Daily");

        ImplNavigation appleMaps=new ImplementationAppleMaps();
        ImplNavigation googleMaps=new ImplementationGoogleMaps();

        uberRides.setNavigationImplementation(appleMaps);
        uberRides.navigate("Delhi");

        uberEats.setNavigationImplementation(googleMaps);
        uberEats.navigate("Mumbai");
    }
}
