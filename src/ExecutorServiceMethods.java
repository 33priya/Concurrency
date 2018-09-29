import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Worker2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ExecutorServiceMethods {

    public static void main(String[] args) {
        ExecutorService service1 = Executors.newCachedThreadPool();

        for (int i = 0; i < 12; ++i) {
            service1.execute(new Worker2());
        }

        ExecutorService service2 = Executors.newFixedThreadPool(5);
        ExecutorService service3 = Executors.newSingleThreadExecutor();


    }
}
