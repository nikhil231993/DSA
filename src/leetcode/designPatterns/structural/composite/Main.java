package leetcode.designPatterns.structural.composite;

public class Main {

    public static void main(String[] args) {

        Employee emp1=new Employee("Raj", 1000.0);
        Employee emp2=new Employee("Rakesh", 5000.0);
        Employee emp3=new Employee("Raju", 300);
        Developer dev1=new Developer("Nikhil", 30000.0);

        Team team=new Team("Avengers");
        team.addComponent(emp1);

        MarketingTeam marketingTeam=new MarketingTeam("AI");
        marketingTeam.addMember(new Employee("Keerti", 4000.0));
        marketingTeam.addMember(new Employee("Ramesh", 40000.0));

        Department department=new Department("Engineering");
        department.addComponent(emp2);
        department.addComponent(emp3);
        department.addComponent(team);
        department.addComponent(dev1);
        department.addComponent(marketingTeam);

        department.displayInfo();

        double totalSalary = department.calculateSalary();
        System.out.println("Total Salary for the Organization: Rs." + totalSalary);
    }
}
