package leetcode.designPatterns.creational.builder.example1;

public class SteelHouseBuilder extends HouseBuilder{

    @Override
    public void buildWindow() {
        this.house.setWindow("Steel Window");
    }

    @Override
    public void buildDoor() {
        this.house.setDoor("Steel Door");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("Steel Roof");
    }

    @Override
    public void buildFloor() {
        this.house.setFloor("Steel Floor");
    }
}
