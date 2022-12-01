import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tem {
    static class Solution {
        private void swap(int[] arr, int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        /**
         * 冒泡排序
         */
        public void bubbleSort(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (nums[j] < nums[j - 1]) {
                        swap(nums, j, j - 1);
                    }
                }
            }
        }

        /**
         * 插入排序
         */
        public void insertionSort(int[] nums) {
            int n = nums.length;
            if (n <= 1) return;
            for (int i = 1; i < n; i++) {
                int x = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > x) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = x;
            }
        }

        /**
         * 选择排序
         */
        public void selectionSort(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++)
                    if (nums[minIdx] > nums[j]) minIdx = j;
                if (minIdx != i) swap(nums, minIdx, i);
            }
        }

        /**
         * 快速排序
         */
        public void quickSort(int[] nums, int l, int r) {
            // 子数组长度为 1 时终止递归
            if (l >= r) return;
            int i = l, j = r;
            while (i < j) {
                while (i < j && nums[j] >= nums[l]) j--;//找到从右开始 第一个 小于 基准的数
                while (i < j && nums[i] <= nums[l]) i++;//找到从左开始 第一个 大于 基准的数
                swap(nums, i, j);//交换两个位置
            }
            swap(nums, i, l);//交换 i 和 基准 的位置  ；此时，基准左边的都小于基准，基准右边的都大于基准
            //分治
            quickSort(nums, l, i - 1);//排基准左边
            quickSort(nums, i + 1, r);//排基准右边
        }

        /**
         * 归并排序
         */
        public void mergeSort(int[] nums, int l, int r) {
            int mid = l + (r - l) / 2;
            if (l < r) {
                mergeSort(nums, mid + 1, r);
                mergeSort(nums, l, mid);
                sort(nums, l, mid, r);
            }
        }

        //把两个数组合在一起
        private void sort(int[] nums, int l, int mid, int r) {
            int[] temp = new int[r - l + 1];
            int index = 0;//新数组起始指针
            int left = l;//左起始指针
            int right = mid + 1;//右起始指针
            //合并两个数组
            while (left <= mid && right <= r) {
                if (nums[left] <= nums[right]) {
                    temp[index++] = nums[left++];
                } else {
                    temp[index++] = nums[right++];
                }
            }
            //把左边剩下的数组加进去
            while (left <= mid) {
                temp[index++] = nums[left++];
            }
            //把右边剩下的数组加进去
            while (right <= r) {
                temp[index++] = nums[right++];
            }
            //覆盖原数组
            System.arraycopy(temp, 0, nums, l, temp.length);
        }

        /**
         * 堆排序
         */
        public void heapSort(int[] nums) {
            //1 构建大根堆
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                //从第一个非叶子节点，从上到下，从右到左调整
                adjustHeap(nums, i, nums.length);
            }
            //2.调整堆结构+交换堆顶元素与末尾元素
            for (int j = nums.length - 1; j > 0; j--) {
                swap(nums, 0, j);//将堆顶元素与末尾元素进行交换
                adjustHeap(nums, 0, j);//重新对堆进行调整
            }
        }

        //创建大根堆
        private void adjustHeap(int[] nums, int i, int length) {
            int temp = nums[i];
            for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
                if (k + 1 < length && nums[k] < nums[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                    k++;
                }
                if (nums[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                    nums[i] = nums[k];
                    i = k;
                } else {
                    break;
                }
            }
            nums[i] = temp;
        }

        /**
         * 希尔排序
         */
        public void shellSort(int[] nums) {
            int n = nums.length;
            //选取gap
            //每次gap/2
            for (int gap = n / 2; gap > 0; gap /= 2) {
                //以当前的gap间隔为数组
                //插入排序
                for (int i = gap; i < n; i++) {
                    int j = i - gap;
                    int x = nums[i];
                    while (j >= 0 && nums[j] > x) {
                        nums[j + gap] = nums[j];
                        j -= gap;
                    }
                    nums[j + gap] = x;
                }
            }
        }

        /**
         * 计数排序
         */
        public void countSort(int[] nums) {
            int n = nums.length;
            if (n < 2) return;
            int minValue = nums[0];
            int maxValue = nums[0];
            //找出数组的最大值和最小值
            for (int num : nums) {
                minValue = Math.min(minValue, num);
                maxValue = Math.max(maxValue, num);
            }
            //创建计数数组，只要小于 就放到计数数组对应的位置
            int[] count = new int[maxValue - minValue + 1];
            for (int num : nums) {
                count[num - minValue]++;
            }
            //遍历计数数组，取出结果
            int idx = 0;
            for (int countIdx = 0; countIdx < count.length; countIdx++) {
                while (count[countIdx]-- > 0) {
                    nums[idx++] = minValue + countIdx;
                }
            }
        }

        /**
         * 桶排序
         */
        public List<Integer> bucketSort(List<Integer> nums, int bucketSize) {
            int n = nums.size();
            if (n < 2 || bucketSize == 0) return nums;
            //获取数组最大值和最小值
            int minValue = nums.get(0);
            int maxValue = nums.get(0);
            for (int num : nums) {
                minValue = Math.min(minValue, num);
                maxValue = Math.max(maxValue, num);
            }
            //获得桶的个数
            int bucketNum = (maxValue - minValue) / bucketSize + 1;
            //创建桶
            List<List<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < bucketNum; i++) {
                buckets.add(new ArrayList<>());
            }
            //向每个桶中添加元素
            for (int num : nums) {
                int idx = (num - minValue) / bucketSize;
                buckets.get(idx).add(num);
            }
            //将桶中的数排序
            for (int i = 0; i < bucketNum; i++) {
                if (buckets.get(i).size() > 0) {
                    buckets.set(i, bucketSort(buckets.get(i), bucketSize / 2));
                }
            }
            //将排序好的结果作为一个列表返回
            List<Integer> result = new ArrayList<>();
            for (List<Integer> bucket : buckets) {
                result.addAll(bucket);
            }
            return result;
        }

        /**
         * 基数排序：将每个数按位比较
         */
        public void radixSort(int[] nums) {
            int n = nums.length;
            if (n < 2) return;
            //求出最大值
            int maxValue = nums[0];
            for (int num : nums) {
                maxValue = Math.max(maxValue, num);
            }
            //求出最大值位数
            int maxC = 1;
            while (maxValue / 10 != 0) {
                maxValue /= 10;
                maxC++;
            }
            //比较每个数的各个位
            for (int i = 0; i < n; i++) {
                //初始化 各个 位 的比较结果表
                List<List<Integer>> radix = new ArrayList<>();
                for (int j = 0; j < 10; j++) {//j<10 : 一位的数 只有 0~9
                    radix.add(new ArrayList<>());
                }
                int idx;
                for (int num : nums) {
                    idx = (num / (int) Math.pow(10, i)) % 10;//取得 num 在 i 位上的数字
                    radix.get(idx).add(num);
                }
                //将该次比较结果 放回原数组
                int numIdx = 0;
                for (List<Integer> list : radix) {
                    for (int num : list) {
                        nums[numIdx++] = num;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 4, 2, 3, 5, 7};
        new Solution().radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
