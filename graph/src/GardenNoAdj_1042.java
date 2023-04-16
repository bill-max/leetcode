import java.util.ArrayList;
import java.util.List;

public class GardenNoAdj_1042 {
    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <n; i++) {
                graph.add(new ArrayList<Integer>());
            }
            //建立无向邻接表
            for (int i = 0; i < paths.length; i++) {
                graph.get(paths[i][0] - 1).add(paths[i][1]);
                graph.get(paths[i][1] - 1).add(paths[i][0]);
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(0);
            }
            //遍历每个花园，种花
            for (int i = 0; i < n; i++) {
                // m用来记录花园i周围邻接的花园种了哪些花
                int[] m = new int[4];
                // 遍历该花园的邻接花园（g.get(i).get(j)表示花园i邻接的第j个花园）
                // 找出每个邻接花园已经种哪些花（通过ans和下标找 若ans值不为0 则种了花 就记录种的哪种花）
                for (int j = 0; j < graph.get(i).size(); j++) {
                    if (ans.get(graph.get(i).get(j) - 1) != 0) {
                        m[ans.get(graph.get(i).get(j) - 1) - 1]++;
                    }
                }
                // 随便找一个没种过的 在花园i种下这个花
                for (int k = 0; k < 4; k++) {
                    if (m[k] == 0) {
                        ans.set(i, k + 1);
                        break;
                    }
                }

            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
