import java.util.Arrays;

public class test {
    public static final int a = 10;

    public static void main(String[] args) {
//        boolean f;
//        System.out.println(f);
        B.test();
    }
}

class A {
    public static final char[] value = new char[]{'1', '2'};
}

class B extends A {
    public static final void test() {
        System.out.println(Arrays.toString(value));
        value[1] = '3';
        System.out.println(Arrays.toString(value));
    }

    public static final void test(int a) {
        value[1] = '5';
        System.out.println(a);
    }
}

