package leetcode.principles.volatileLearnings.issue;

public class VolatileIssue {

    private boolean flag = false; // This flag is volatile

    public void setFlagTrue() {
        flag = true;
    }

    public void run() {

        while (!flag) {
            System.out.println("test");
            // Busy-wait loop
        }
        System.out.println("Flag has been set to true!");
    }

    public static void main(String[] args) {

        VolatileIssue example = new VolatileIssue();

        Thread setter = new Thread(example::setFlagTrue);
        Thread runner = new Thread(example::run);

        setter.start();
        runner.start();
    }
}
