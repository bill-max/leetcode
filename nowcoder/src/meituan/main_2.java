package meituan;

import java.util.Collections;

public class main_2 {

    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println("kk" + i++);
            if (i == 3) {
                continue;
            }
        } while (i < 10);
    }

}