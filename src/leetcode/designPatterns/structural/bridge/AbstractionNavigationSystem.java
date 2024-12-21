package leetcode.designPatterns.structural.bridge;

public abstract class AbstractionNavigationSystem {

    //Abstraction Layer

    protected ImplementationNavigation navigationSystem;

    abstract void navigate(String destination);

    public void setNavigationImplementation(ImplementationNavigation navigationSystem){
        this.navigationSystem=navigationSystem;
    }
}
