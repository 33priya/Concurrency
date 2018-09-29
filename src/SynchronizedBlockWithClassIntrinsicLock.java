public class SynchronizedBlockWithClassIntrinsicLock {
    private static int count1 = 0;
    private static int count2 = 0;

    private static void incrementCount1() {
        synchronized (SynchronizedBlockWithClassIntrinsicLock.class) {
            ++count1;
        }
    }

    private static void incrementCount2() {
        synchronized (SynchronizedBlockWithClassIntrinsicLock.class) {
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
