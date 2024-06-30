package leetcode.designPatterns.builder.example1;

public class IceHouseBuilder extends HouseBuilder{

    @Override
    public void buildWindow() {
        this.house.setWindow("Ice Window");
    }

    @Override
    public void buildDoor() {
        this.house.setDoor("Ice Door");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("Ice Roof");
    }

    @Override
    public void buildFloor() {
        this.house.setFloor("Ice Floor");
    }
}
