package meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = reader.read()-'0';
        reader.read();
        int a = reader.read();
        System.out.println(n);
        System.out.println(a);
    }
}
