package leetcode.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

//Composite
public class Team implements EmployeeComponent{

    private String name;
    private List<EmployeeComponent> team=new ArrayList<>();

    public Team(String name){
        this.name=name;
    }

    public void addComponent(EmployeeComponent employeeComponent){
        this.team.add(employeeComponent);
    }


    @Override
    public void displayInfo() {
        System.out.println("Team is : "+ name);
        for(EmployeeComponent member: team)
            member.displayInfo();
    }

    @Override
    public double calculateSalary() {
        double toatalSalary=0.0;
        for(EmployeeComponent member: team)
            toatalSalary+=member.calculateSalary();
        return toatalSalary;
    }
}
