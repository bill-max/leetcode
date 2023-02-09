package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bottle_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            if (t == 0) break;
            list.add(t);
        }
        for (Integer num : list) {
            System.out.println(solution(num));
        }
    }

    private static int solution(int num) {
        int ans = 0;
        while (num >= 3) {
            ans += num / 3;
            num = num / 3 + num % 3;
        }
        if (num == 2) {
            ans++;
        }
        return ans;
    }

}
