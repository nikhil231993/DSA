package leetcode.principles.InterfaceDemo;

public interface Car {

    public int num = 0;

    public static void starting(){
        System.out.println("Starting Interface car");
    }

    public static void start() {
        System.out.println("Start Swift car");
    }

    default void startTest() {
        System.out.println("Start Swift car");
    }

    void print();

//    default void testing();  // Default methods cannot be empty
}
