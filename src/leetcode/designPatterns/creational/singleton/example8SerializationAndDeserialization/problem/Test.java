package leetcode.designPatterns.creational.singleton.example8SerializationAndDeserialization.problem;

import java.io.*;

class Singleton implements Serializable {

    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}

public class Test {

    public static void main(String[] args) throws Exception {

        Singleton instance1 = Singleton.getInstance();

        // Serialize the instance
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        // Deserialize the instance
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println("Same instance? " + (instance1 == instance2));
    }
}

