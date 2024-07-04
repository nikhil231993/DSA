package leetcode.designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

//Composite
public class Department implements EmployeeComponent{

    private String name;
    private List<EmployeeComponent> department=new ArrayList<>();

    public Department(String name){
        this.name=name;
    }

    public void addComponent(EmployeeComponent employeeComponent){
        this.department.add(employeeComponent);
    }

    @Override
    public void displayInfo() {

        System.out.println("Department is : "+ name);
        for(EmployeeComponent member: department)
            member.displayInfo();
    }

    @Override
    public double calculateSalary() {

        double toatalSalary=0.0;
        for(EmployeeComponent member: department)
            toatalSalary+=member.calculateSalary();
        return toatalSalary;
    }
}
