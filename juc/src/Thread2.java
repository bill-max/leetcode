public class Thread2 {
    static class RunTask implements Runnable {
        private int num = 1;

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if(num>10) break;
                    notifyAll();
                    if (num <= 10) {
                        System.out.println(Thread.currentThread().getName() + ":" + num);
                        num++;
                        try {
                            wait();
//                            System.out.println(Thread.currentThread().getName() + "wait");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunTask runTask = new RunTask();
        Thread thread = new Thread(runTask);
        Thread thread2 = new Thread(runTask);
        thread.start();
        thread2.start();

    }
}
