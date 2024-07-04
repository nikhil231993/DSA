package leetcode.designPatterns.structural.bridge;

public class UberEats extends Uber {

    private String name;

    public UberEats(String name){
        this.name=name;
    }

    public void setNavigationSystem(NavigationSystem navigationSystem) {
        this.navigationSystem = navigationSystem;
    }

    @Override
    public void navigateTo(String destination) {
        System.out.print("Uber Eats delivery from " + name + " to " + destination + " using ");
        this.navigationSystem.navigate(destination);
    }
}
