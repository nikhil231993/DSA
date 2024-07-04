package leetcode.designPatterns.structural.bridge;

public abstract  class Uber {

    protected NavigationSystem navigationSystem;

    abstract void navigateTo(String destination);
}
