package leetcode.designPatterns.composite;

public class Main {
    public static void main(String[] args) {
        Employee emp1=new Employee("Raj", 1000.0);
        Employee emp2=new Employee("Rakesh", 5000.0);
        Employee emp3=new Employee("Raju", 300);

        Team team=new Team("Avengers");
        team.addComponent(emp1);

        Department department=new Department("Engineering");
        department.addComponent(emp2);
        department.addComponent(emp3);
        department.addComponent(team);

        department.displayInfo();

        double totalSalary = department.calculateSalary();
        System.out.println("Total Salary for the Organization: Rs." + totalSalary);

    }
}
