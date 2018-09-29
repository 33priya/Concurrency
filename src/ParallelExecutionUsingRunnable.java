class Runner11 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner11: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner22 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner22: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ParallelExecutionUsingRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner11());
        Thread t2 = new Thread(new Runner22());

        t1.start();
        t2.start();
    }
}
