package leetcode.designPatterns.creational.factoryAbstract.example2;

public class FurnitureFactory {

    public static IFurnitureFactory buildFurniture(String type){

        switch (type){
            case "modern":
                return new ModernFurniture();
            case "traditional":
                return new TraditionalFurniture();
        }
        return null;
    }
}
