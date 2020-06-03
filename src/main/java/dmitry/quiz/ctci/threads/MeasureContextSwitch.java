package dmitry.quiz.ctci.threads;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 15.2
 * Context Switch: How would you measure the time spent in a context switch?
 * Idea: run several threads, synchronized by the same lock. Track enter/exit time.
 * Avg time from last exit and current enter is a context switch time
 * Track enter/exit time
 */
public class MeasureContextSwitch {

    private static class LockInfo {
        // Track last release time here
        long lastNanoTime = System.nanoTime();
    }

    private final static LockInfo lockObj = new LockInfo();

    /**
     * Function to calculate delta time from previous thread
     */
    private static long measure() {
        synchronized (lockObj) {
            // Calc time from last lock - it is context swith time
            long deltaTime = System.nanoTime() - lockObj.lastNanoTime;
            // Update last lock time
            lockObj.lastNanoTime = System.nanoTime();
            return deltaTime;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create and invoke some threads
        int attempts = 1;
        ExecutorService pool = Executors.newFixedThreadPool(attempts);

        // Gather results. Exception handling prevents us to use labmdas effectively here, so it is vanilla foreach ))
        double avgTime = 0;
        lockObj.lastNanoTime = System.nanoTime();
        List<Future<Long>> results = pool.invokeAll(Collections.nCopies(attempts, MeasureContextSwitch::measure));
        for (Future<Long> result : results) {
            avgTime += (result.get() / attempts);
        }

        // Convert from nanos to seconds
        avgTime /= 1000000000;
        System.out.printf("Avg context switch sec: %f", avgTime);
    }

}
