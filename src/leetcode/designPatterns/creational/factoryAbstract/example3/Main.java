package leetcode.designPatterns.creational.factoryAbstract.example3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();

        LoggerFactory factory=Factory.createFactory(str);
        
        if(factory != null){
            ErrorLogger errorLogger = factory.createErrorLogger();
            errorLogger.errorDisplay();
        }else{
            System.out.println("Error");
        }
    }
}
