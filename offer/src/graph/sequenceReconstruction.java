package graph;

import java.util.*;

public class sequenceReconstruction {
    static class Solution1 {
        //逆向思维，根据nums构造唯一序列，检查是否存在从第一个点到最后一个点的路径即可
        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums.length; i++) map.put(nums[i - 1], nums[i]);

            int[] path = new int[nums.length + 1];
            for (int[] sequence : sequences) {
                for (int i = 1; i < sequence.length; i++) {
                    //如果i-1 == i 那么说明存在该路径
                    if (map.getOrDefault(sequence[i - 1], -1) == sequence[i]) path[sequence[i]] = 1;
                }
            }

            return Arrays.stream(path).sum() == nums.length - 1;
        }
    }

    static class Solution2 {
        //常规方法，拓扑排序
        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            int n = nums.length;
            //根据sequence建图
            Set<Integer>[] graph = new Set[n + 1];
            int[] indegrees = new int[n + 1];
            for (int i = 0; i < graph.length; i++) graph[i] = new HashSet<>();

            for (int[] sequence : sequences) {
                int size = sequence.length;
                for (int i = 1; i < size; i++) {
                    //添加有向边
                    if (graph[sequence[i - 1]].add(sequence[i])) {
                        //计算入度
                        indegrees[sequence[i]]++;
                    }

                }
            }

            //拓扑排序
            Queue<Integer> queue = new ArrayDeque<>();
            //不能把indegrees[0]这个点加进去，这个点没有用到
            for (int i = 1; i < indegrees.length; i++)
                if (indegrees[i] == 0) queue.offer(i);

            while (!queue.isEmpty()) {
                //该题条件下，入度不能大于1
                if (queue.size() > 1) return false;
                int cur = queue.poll();
                Set<Integer> set = graph[cur];
                for (int next : set) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) queue.offer(next);
                }
            }

            return true;
        }
    }
}

