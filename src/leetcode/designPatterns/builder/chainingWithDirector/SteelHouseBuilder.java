package leetcode.designPatterns.builder.chainingWithDirector;

public class SteelHouseBuilder extends HouseBuilder {

    @Override
    public HouseBuilder buildWindow() {
        this.house.setWindow("Steel Window");
        return this;
    }

    @Override
    public HouseBuilder buildDoor() {
        this.house.setDoor("Steel Door");
        return this;
    }

    @Override
    public HouseBuilder buildRoof() {
        this.house.setRoof("Steel Roof");
        return this;
    }

    @Override
    public HouseBuilder buildFloor() {
        this.house.setFloor("Steel Floor");
        return this;
    }
}
