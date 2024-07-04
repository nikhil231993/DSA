package leetcode.designPatterns.structural.facade;

public class ComputerDemo {

    public static void main(String[] args) {

        // Subsystem 1: CPU
        // Subsystem 2: Memory
        // Subsystem 3: GPU
        // Subsystem 4: Disk Drive
        // Subsystem 5: Network Interface
        // Facade: Computer System
        ComputerSystemFacade computer = new ComputerSystemFacade();

        // User initiates the computer startup process with a single call
        computer.startComputer();
    }
}
