package leetcode.designPatterns.factoryAbstract.example2;

import leetcode.designPatterns.factoryAbstract.example1.IFactory;

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
