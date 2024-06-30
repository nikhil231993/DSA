package leetcode.designPatterns.builder.example2chainingWithDirector;

public class WoodenHouseBuilder extends HouseBuilder {

    @Override
    public HouseBuilder buildWindow() {
        this.house.setWindow("Wooden Window");
        return this;
    }

    @Override
    public HouseBuilder buildDoor() {
        this.house.setDoor("Wooden Door");
        return this;
    }

    @Override
    public HouseBuilder buildRoof() {
        this.house.setRoof("Wooden Roof");
        return this;
    }

    @Override
    public HouseBuilder buildFloor() {
        this.house.setFloor("Wooden Floor");
        return this;
    }
}
