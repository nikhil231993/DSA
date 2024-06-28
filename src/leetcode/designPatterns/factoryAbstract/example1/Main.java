package leetcode.designPatterns.factoryAbstract.example1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String str= scan.nextLine();
        scan.close();

        IFactory factory= GUIFactory.getFactory(str);
        if(factory!=null){
            IButton button=factory.createButton();
            button.buttonPressed();
        }else
            System.out.println("Invalid input");
    }
}
