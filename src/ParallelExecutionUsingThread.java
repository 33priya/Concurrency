class Runner111 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner111: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner222 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner222: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ParallelExecutionUsingThread {
    public static void main(String[] args) {
        Runner111 t1 = new Runner111();
        Runner222 t2 = new Runner222();

        t1.start();
        t2.start();
    }
}
