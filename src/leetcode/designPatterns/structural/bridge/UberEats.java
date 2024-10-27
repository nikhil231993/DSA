package leetcode.designPatterns.structural.bridge;

public class UberEats extends NavigationSystem {

    //Abstraction
    private String name;

    public UberEats(String name){
        this.name=name;
    }

    @Override
    public void navigate(String destination) {
        System.out.print("Uber Eats delivery from " + name + " to " + destination + " using ");
        this.navigationSystem.navigateTo(destination);
    }
}
