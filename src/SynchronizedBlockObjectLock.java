public class SynchronizedBlockObjectLock {
    private static int count1 = 0;
    private static int count2 = 0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static void incrementCount1() {
        synchronized (lock1) {
            ++count1;
        }
    }

    private static void incrementCount2() {
        synchronized (lock2) {
            ++count2;
        }
    }

    private static void compute() {
        for (int i = 0; i < 100; ++i) {
            incrementCount1();
            incrementCount2();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count1 = " + count1 + " Count2 = " + count2);
    }
}
