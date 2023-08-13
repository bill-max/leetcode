public class ThreadVolatile {
    private volatile int num = 1;

    public static void main(String[] args) {
        ThreadVolatile a = new ThreadVolatile();
        new Thread(() -> {
            while (true) {
                if (a.num > 100) break;
                if (a.num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + a.num);
                    a.num = a.num + 1;
                }
            }
        },"A").start();
        new Thread(() -> {
            while (true) {
                if (a.num > 100) break;
                if (a.num % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + a.num);
                    a.num = a.num + 1;
                }
            }
        },"B").start();
    }
}
