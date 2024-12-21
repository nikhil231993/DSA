package leetcode.designPatterns.structural.bridge;

public class Main {

    public static void main(String[] args) {

        //We can have both NavigationSystem and NavigationImplementation as interface but
        //if we have NavigationSystem as abstract class then we can create reference of ImplNavigation inside it

        AbstractionNavigationSystem uberRides=new AbstractionUberRides("Raj");
        AbstractionNavigationSystem uberEats=new AbstractionUberEats("Daily");

        ImplementationNavigation appleMaps=new ImplementationAppleMaps();
        ImplementationNavigation googleMaps=new ImplementationGoogleMaps();

        uberRides.setNavigationImplementation(appleMaps);
        uberRides.navigate("Delhi");

        uberEats.setNavigationImplementation(googleMaps);
        uberEats.navigate("Mumbai");
    }
}
