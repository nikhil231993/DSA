package leetcode.designPatterns.creational.builder.example2chainingWithDirector;

public class House {

    private String window;

    private String door;

    private String roof;

    private String floor;

    public String getWindow() {
        return window;
    }

    public String getDoor() {
        return door;
    }

    public String getRoof() {
        return roof;
    }

    public String getFloor() {
        return floor;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
