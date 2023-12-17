package leetcode.designPatterns.builder.example4;

public class WoodenHouseBuilder extends HouseBuilder{

    @Override
    public void buildWindow() {
        this.house.setWindow("Wooden Window");
    }

    @Override
    public void buildDoor() {
        this.house.setDoor("Wooden Door");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("Wooden Roof");
    }

    @Override
    public void buildFloor() {
        this.house.setFloor("Wooden Floor");
    }
}
