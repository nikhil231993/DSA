package leetcode.designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class MarketingTeam implements EmployeeComponent{

    private String name;

    private List<EmployeeComponent> marketingList=new ArrayList<>();

    public MarketingTeam(String name){
        this.name=name;
    }

    public void addMember(EmployeeComponent employeeComponent){
        this.marketingList.add(employeeComponent);
    }

    @Override
    public void displayInfo() {

        System.out.println("Marketing Team is : "+this.name);
        for(EmployeeComponent employeeComponent:marketingList)
            employeeComponent.displayInfo();
    }

    @Override
    public double calculateSalary() {

        double salary=0.0;
        System.out.println("Marketing Team is : "+ name);
        for(EmployeeComponent employeeComponent:marketingList)
            salary+=employeeComponent.calculateSalary();
        return salary;
    }

}
