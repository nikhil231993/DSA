package leetcode.designPatterns.builder.example1;

public class CivilEngineer {

    public HouseBuilder houseBuilder;

    public CivilEngineer (HouseBuilder houseBuilder){
        this.houseBuilder=houseBuilder;
    }

    public void construct(){
        this.houseBuilder.buildDoor();
        this.houseBuilder.buildWindow();
        this.houseBuilder.buildFloor();
        this.houseBuilder.buildRoof();
    }

    public House build(){
        return this.houseBuilder.buildHouse();
    }
}
