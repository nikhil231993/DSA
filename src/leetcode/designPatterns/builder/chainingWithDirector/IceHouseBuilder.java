package leetcode.designPatterns.builder.chainingWithDirector;

public class IceHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder buildWindow() {
        this.house.setWindow("Ice Window");
        return this;
    }

    @Override
    public HouseBuilder buildDoor() {
        this.house.setDoor("Ice Door");
        return this;
    }

    @Override
    public HouseBuilder buildRoof() {
        this.house.setRoof("Ice Roof");
        return this;
    }

    @Override
    public HouseBuilder buildFloor() {
        this.house.setFloor("Ice Floor");
        return this;
    }
}
