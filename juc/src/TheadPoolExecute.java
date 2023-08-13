import java.util.concurrent.*;

public class TheadPoolExecute {
    private static final int coreThreadPoolSize = 2;
    private static final int maxPoolSize = 10;
    private static final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
    private static final long keepAliveTime = 1000;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                coreThreadPoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MICROSECONDS,
                workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10 * 1000);
                        System.out.println(Thread.currentThread().getName() + ":" + "正在运行");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executor.shutdown();


    }
}
