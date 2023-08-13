import java.util.concurrent.locks.*;

public class ThreadCondition {
    private int num = 0;
    private static Lock lock = new ReentrantLock(false);

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Condition c1 = lock.newCondition();
    private static final Condition c2 = lock.newCondition();
    private static final Condition c3 = lock.newCondition();

    private void runTask(int aim, Condition cur, Condition next) {
        while (true) {
            lock.lock();
            try {
                while (num % 3 != aim) {
//                    System.out.println(Thread.currentThread().getName() + "---wait");
                    cur.await();
                }
                if (num > 10) break;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
//                next.signal();
                next.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCondition threadCondition = new ThreadCondition();
        new Thread(() -> {
            threadCondition.runTask(0, c1, c2);
        }).start();
        new Thread(() -> {
            threadCondition.runTask(1, c2, c3);
        }).start();
        new Thread(() -> {
            threadCondition.runTask(2, c3, c1);
        }).start();
    }
}
