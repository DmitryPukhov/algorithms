package dmitry.quiz.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * 15.2
 * Context Switch: How would you measure the time spent in a context switch?
 * ToDo: add measurement code
 */
public class MeasureContextSwitch {

    private static Object lock = new Object();
    private int cycles = 3;
    private int curCycle = 0;

    /**
     * Job with context switch time measurement
     */
    class Measurement implements Runnable {
        private final int processId;
        private final static int timeOutMillis = 1000;
        private final DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");


        public Measurement(int processNum) {
            this.processId = processNum;
        }

        @Override
        public void run() {
            //long time= System.currentTimeMillis();
            System.out.printf("%tT.%<tL Starting process%d\n", LocalTime.now(), processId);
            for (int i = 1; i <= cycles; i++) {
                // Odd process in odd cycles sends
                // Even process in even cycles receives
                if (processId % 2 == 1) {
                    System.out.printf("%tT.%<tL Cycle%d process%d sending\n", LocalTime.now(), i, processId);
                    // Send in this cycle
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                    System.out.printf("%tT.%<tL Cycle%d process%d sent\n", LocalTime.now(), i, processId);
                } else {
                    // Receive in this cycle
                    try {
                        System.out.printf("%tT.%<tL Cycle%d process%d receiving\n", LocalTime.now(), i, processId);
                        synchronized (lock) {
                            lock.wait(timeOutMillis);
                        }
                        System.out.printf("%tT.%<tL Cycle%d process%d received\n", LocalTime.now(), i, processId);
                    } catch (InterruptedException e) {
                        System.out.printf("%tT.%<tL Cycle%d process%d exception. ", LocalTime.now(), i, processId);
                        System.out.print(e);
                    }
                }
            }
            System.out.printf("%tT.%<tL Process%d end of loop\n", LocalTime.now(), processId);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new MeasureContextSwitch().run();

    }

    void run() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future f1 = executor.submit(new Measurement(1));
        Future f2 = executor.submit(new Measurement(2));
        executor.shutdown();
        boolean isGoodTermination = executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.printf("%tT %<tL Terminated. Is good: %b\n", LocalTime.now(), isGoodTermination);
        System.out.printf("%tT %<tL Process1:%b, process2:%b\n", LocalTime.now(), f1.isDone(), f2.isDone());
    }
}
