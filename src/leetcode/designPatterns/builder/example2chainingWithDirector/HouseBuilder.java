package leetcode.designPatterns.builder.example2chainingWithDirector;

public abstract class HouseBuilder {

    protected House house; //Your access it within the implemented classes

    public HouseBuilder(){
        this.house=new House();
    }

    public abstract HouseBuilder buildWindow();

    public abstract HouseBuilder buildDoor();

    public abstract HouseBuilder buildRoof();

    public abstract HouseBuilder buildFloor();

    public House buildHouse(){
        return this.house;
    }
}
