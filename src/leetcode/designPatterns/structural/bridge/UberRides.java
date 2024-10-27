package leetcode.designPatterns.structural.bridge;

public class UberRides extends NavigationSystem {

    //Abstraction
    private String name;

    public UberRides(String name){
        this.name=name;
    }

    @Override
    public void navigate(String destination) {
        System.out.print("Uber ride with " + name + " to " + destination + " using ");
        this.navigationSystem.navigateTo(destination);
    }
}
