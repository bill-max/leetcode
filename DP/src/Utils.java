public class Utils {
    /**
     * 打印一个二维数组
     * @param arr
     */
    public void print(int[][] arr) {
        for (int[] a : arr) {
            System.out.print('[');
            for (int s : a) {
                System.out.print(s);
                System.out.print(',');
            }
            System.out.println(']');
        }
    }

    /**
     * 打印一个一维数组
     * @param arr
     */
    public void print(int[] arr) {
        System.out.print('[');
        for (int a : arr) {
            System.out.print(a);
            System.out.print(',');
        }
        System.out.println(']');
    }
}
