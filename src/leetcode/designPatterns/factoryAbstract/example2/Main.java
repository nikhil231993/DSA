package leetcode.designPatterns.factoryAbstract.example2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String type=scan.nextLine();
        scan.close();

        IFurnitureFactory furniture=FurnitureFactory.buildFurniture(type);
        if(furniture!=null){
            IAlmirah almirah=furniture.createAlmirah();
            almirah.keepClothes();
        }
    }
}
