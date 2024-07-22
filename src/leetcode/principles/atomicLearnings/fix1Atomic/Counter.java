package leetcode.principles.atomicLearnings.fix1Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends  Thread{

    // Atomic counter Variable
    AtomicInteger count;

    // Constructor of class
    Counter()
    {
        count = new AtomicInteger();
    }

    // method which would be called upon
    // the start of execution of a thread
    public void run() {

        int max = 1_000_00_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}
