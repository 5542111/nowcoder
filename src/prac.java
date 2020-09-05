import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;;

public class prac {
    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<>(200);
//        System.out.println(list);
//        for (int i = 0; i <201 ; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        if (list.size()>200)
//        {
//            list.remove(0);
//        }
//
//        System.out.println(list.size());
//        Integer integer = new Integer(Integer.MAX_VALUE);
//
//        String str = Integer.toBinaryString(integer);
//        System.out.println(str.length());
//        System.out.println(str);
//        System.out.println(str.replace("0", "").length());
        Resource resource = new Resource();


          new Thread(() -> {
              for (int i = 0; i < 10; i++) {
                  resource.Produce();
              }
          }, "A").start();
          new Thread(() -> {
              for (int i = 0; i < 10; i++) {
                  resource.Consume();
              }
          }, "B").start();



    }
}

class Resource {
    private int buffer = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean isEmpty = true;

    public void Consume() {
        lock.lock();
        try {
            while (isEmpty) {
                condition.await();
            }

            System.out.println(Thread.currentThread().getName() + "购买了当前的票" + buffer);
            buffer--;
            if (buffer == 0) {
                isEmpty = true;
                condition.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void Produce() {
        lock.lock();
        try {
            while (!isEmpty) {
                condition.await();
            }
            buffer++;
            System.out.println(Thread.currentThread().getName() + "增加了第" + buffer + "张票");
            if (buffer == 10) {
                isEmpty = false;
                condition.signal();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
