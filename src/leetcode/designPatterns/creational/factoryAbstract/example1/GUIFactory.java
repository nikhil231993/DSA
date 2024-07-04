package leetcode.designPatterns.creational.factoryAbstract.example1;

public class GUIFactory {

    public static IFactory getFactory(String name){

        switch (name){
            case "windows":
                return new WinFactory();
            case "mac":
                return new MacFactory();
        }
        return null;
    }
}
