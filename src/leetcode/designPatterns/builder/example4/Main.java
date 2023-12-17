package leetcode.designPatterns.builder.example4;

public class Main {

    public static void main(String[] args) {
        HouseBuilder houseBuilder=new IceHouseBuilder();
        CivilEngineer civilEngineer=new CivilEngineer(houseBuilder);
        civilEngineer.construct();

        House house=civilEngineer.build();
        System.out.println(house.getDoor());
        System.out.println(house.getWindow());
        System.out.println(house.getFloor());
        System.out.println(house.getRoof());
    }
}
