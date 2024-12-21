package leetcode.designPatterns.structural.composite;

public class Developer implements EmployeeComponent{

    private String name;

    private double salary;

    public Developer(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Developer: " + name + " Salary is Rs : " + salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
