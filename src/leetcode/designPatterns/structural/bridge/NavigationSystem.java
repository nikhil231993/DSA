package leetcode.designPatterns.structural.bridge;

public abstract class NavigationSystem {

    //Abstraction Layer

    protected ImplNavigation navigationSystem;

    abstract void navigate(String destination);

    public void setNavigationImplementation(ImplNavigation navigationSystem){
        this.navigationSystem=navigationSystem;
    }
}
