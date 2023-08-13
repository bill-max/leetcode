import java.util.concurrent.*;

public class ThreadPoolSubmit {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(1,
                2,
                1000,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(2)
        );
        Future<Integer> submit = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                return sum;
            }
        });

        try {
            Integer integer = submit.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        executor.isShutdown();
        executor.isTerminated();
        executor.awaitTermination(10, TimeUnit.MILLISECONDS);
//        executor.shutdownNow()

    }
}
