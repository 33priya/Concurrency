import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processor2 {
    private final Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await();
        System.out.println("Producer again...");
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println("Consumer method...");
        condition.signal();
        lock.unlock();
    }
}

public class AwaitAndSignal {
    public static void main(String[] args) {
        Processor2 processor = new Processor2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
    }
}
