import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class offer_40 {
    static class Solution {
        /**
         * topK 问题  有两种经典解法
         * 1，快排 改进
         * 2. 堆
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            int[] ans = new int[k];
            System.arraycopy(arr, 0, ans, 0, k);
            return ans;
        }

        /**
         * 快排改进算法   O(n)  O(logN)
         * 题目只要求返回最小的 k 个数，对这 k 个数的顺序并没有要求。因此，只需要将数组划分为 最小的 k 个数 和 其他数字 两部分即可，而快速排序的哨兵划分可实现此目标。
         * 根据快速排序原理，如果某次哨兵划分后 基准数正好是第 k+1 小的数字 ，那么此时基准数左边的所有数字便是题目所求的 最小的 k 个数 。
         * 根据此思路，考虑在每次哨兵划分后，判断基准数在数组中的索引是否等于 k ，若 true 则直接返回此时数组的前 k 个数字即可。
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            return quickSort(arr, 0, arr.length - 1, k);
        }

        private int[] quickSort(int[] arr, int l, int r, int k) {
            int i = l, j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) j--;//找到从右开始 第一个 小于 基准的数
                while (i < j && arr[i] <= arr[l]) i++;//找到从左开始 第一个 大于 基准的数
                swap(arr, i, j);//交换两个位置
            }
            swap(arr, i, l);//交换 i 和 基准 的位置  ；此时，基准左边的都小于基准，基准右边的都大于基准
            //分治
            if (i > k) quickSort(arr, l, i - 1, k);// 此时 i 之前的 都小于 arr[i] 只需要排序前面的就好
            else if (i < k) quickSort(arr, i + 1, r, k); //排序右边
            return Arrays.copyOf(arr, k);
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        /**
         * 大根堆(前 K 小) / 小根堆（前 K 大),Java中有现成的 PriorityQueue
         * 本题是求前 K 小， 因此用一个容量为 K 的大根堆，每次 poll 出最大的数，那堆中保留的就是前 K 小
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers3(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            // 使用一个最大堆（大顶堆）
            // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
            Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
            for (int e : arr) {
                // 当前数字小于堆顶元素才会入堆
                if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                    heap.offer(e);
                }
                if (heap.size() > k) {
                    heap.poll(); // 删除堆顶最大元素
                }
            }

            return heap.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
