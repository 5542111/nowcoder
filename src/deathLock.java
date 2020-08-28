import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class deathLock {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                data.increment();

            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                data.decrement();
            }
        }, "B").start();

    }


}

//资源类


class Data {
    private int num = 1;
    private Lock lock = new ReentrantLock();

    public void increment() {
         synchronized (this) {
        try {
            while (num % 2 == 0) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + "购买了第" + num + "张票");
            num++;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.notifyAll();

        }
         }

    }

    public void decrement() {
        synchronized (this) {

            try {
                while (num % 2 == 1) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + "购买了第" + num + "张票");
                num++;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.notifyAll();

            }
        }

    }
}

