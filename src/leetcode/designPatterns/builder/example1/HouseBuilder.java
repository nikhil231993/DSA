package leetcode.designPatterns.builder.example1;

public abstract class HouseBuilder {

    protected House house; //Your access it within the implemented classes

    public HouseBuilder(){
        this.house=new House();
    }

    public abstract void buildWindow();

    public abstract void buildDoor();

    public abstract void buildRoof();

    public abstract void buildFloor();

    public House buildHouse(){
        return this.house;
    }
}
