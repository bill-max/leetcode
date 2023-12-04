public class ThreadVolatile {
    private volatile int num = 1;

    public static void main(String[] args) {
        ThreadVolatile a = new ThreadVolatile();
        new Thread(() -> {
            while (true) {
                if (a.num % 2 == 0) {
                    if (a.num > 10) break;
                    System.out.println(Thread.currentThread().getName() + ":" + a.num);
                    a.num = a.num + 1;
                }
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                if (a.num % 2 == 1) {
                    if (a.num > 10) break;
                    System.out.println(Thread.currentThread().getName() + ":" + a.num);
                    a.num = a.num + 1;
                }
            }
        }, "B").start();
    }
}
