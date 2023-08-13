import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> ans = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>(n, (o1, o2) -> o2 - o1);
        List<Integer> a = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + cnt);
            a.add(num);
            a.sort((o1, o2) -> o2 - o1);
            StringBuilder sb = new StringBuilder();
            for (int number : a) {
                for (int j = 0; j < map.get(number); j++) {
                    sb.append(number);
                }
            }
            if (sb.length() <= n) {
                ans.add(sb.toString());
            } else {
                ans.add(sb.substring(0, n));
            }
        }


        for (String s : ans) {
            System.out.println(s);
        }


    }
}
