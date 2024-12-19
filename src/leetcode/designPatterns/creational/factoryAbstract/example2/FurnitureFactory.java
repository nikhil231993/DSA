package leetcode.designPatterns.creational.factoryAbstract.example2;

public class FurnitureFactory {

    public static IFurnitureFactory buildFurniture(String type){

        switch (type){
            case "modern":
                return new ModernFurnitureFactory();
            case "traditional":
                return new TraditionalFurnitureFactory();
        }
        return null;
    }
}
