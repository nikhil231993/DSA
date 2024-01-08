package leetcode.designPatterns.bridge;

public class UberRides implements NavigationImplementation{

    private String name;
    private NavigationSystem navigationSystem;

    public UberRides(String name){
        this.name=name;
    }

    public void setNavigationImplementation(NavigationSystem navigationSystem){
        this.navigationSystem=navigationSystem;
    }

    @Override
    public void navigateTo(String destination) {
        System.out.print("Uber ride with " + name + " to " + destination + " using ");
        this.navigationSystem.navigate(destination);
    }
}
