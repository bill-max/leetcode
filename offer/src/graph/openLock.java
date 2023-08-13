package graph;

import java.util.*;
import java.util.stream.Collectors;

public class openLock {
    static class Solution {
        public int openLock(String[] deadends, String target) {
            if ("0000".equals(target)) return 0;
            Set<String> dead = Arrays.stream(deadends).collect(Collectors.toSet());
            if (dead.contains("0000")) return -1;

            int step = 0;
            Queue<String> q = new ArrayDeque<>();
            q.offer("0000");
            Set<String> vis = new HashSet<>();
            vis.add("0000");
            while (!q.isEmpty()) {
                ++step;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String node = q.poll();
                    for (String nextStatus : getStatus(node)) {
                        if (!vis.contains(nextStatus) && !dead.contains(nextStatus)) {
                            if (nextStatus.equals(target)) return step;
                            q.offer(nextStatus);
                            vis.add(nextStatus);
                        }
                    }
                }
            }
            return -1;
        }

        private List<String> getStatus(String str) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder(str);
                int chAdd = str.charAt(i) - '0' + 1;
                sb.setCharAt(i, (char) (chAdd % 10 + '0'));
                res.add(sb.toString());
                int chSub = str.charAt(i) - '0' + 9;
                sb.setCharAt(i, (char) (chSub % 10 + '0'));
                res.add(sb.toString());
                sb.setCharAt(i, str.charAt(i));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
