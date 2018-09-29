class Runner1111 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner1111: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2222 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Runner2222: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadJoin {

    public static void main(String[] args) {
        Runner1111 t1 = new Runner1111();
        Runner2222 t2 = new Runner2222();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished the tasks...");
    }
}
