package leetcode.designPatterns.builder.chainingWithDirector;

public class CivilEngineer {

    public HouseBuilder houseBuilder;

    public CivilEngineer (HouseBuilder houseBuilder){
        this.houseBuilder=houseBuilder;
    }

    public void construct(){
        this.houseBuilder.buildDoor().buildWindow().buildFloor();
    }

    public House build(){
        return this.houseBuilder.buildHouse();
    }
}
