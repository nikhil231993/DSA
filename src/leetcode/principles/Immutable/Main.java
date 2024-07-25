package leetcode.principles.Immutable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);

        Date d=new Date(2123324134);
        Driver driver=new Driver(1,"Test",set,d);
        set.add(3); //we need to handle the constructor also as without that we will still be able to change it
        int a=driver.getA();
        String s=driver.getName();
        Date d1=driver.getD();

        System.out.println(driver.getD());
        d1.setTime(453453453);
        a=100;
        s="trial";
        System.out.println(driver.getA());
        System.out.println(driver.getName());
        System.out.println(driver.getD());

        Set<Integer> modSet=driver.getSet();
        modSet.add(3);
        System.out.println(modSet);
        //even though I am making change in the modset but still the original set is getting changed
        System.out.println(driver.getSet());
    }
}
