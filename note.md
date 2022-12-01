# 列表
## 环形列表问题：快慢指针
```java
    public static class Solution {
        /**
         * 快慢指针第二次相遇，一定是在环的入口处
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head==null||head.next==null) return null;
            ListNode fast = head;
            ListNode low = head;
            //第一次相遇
            do {
                if (fast == null || fast.next == null) return null;
                fast = fast.next.next;
                low = low.next;
            } while (fast != low);
            //第二次相遇
            fast = head;
            while (fast != low) {
                fast = fast.next;
                low = low.next;
            }
            return fast;
        }
    }
```

# 排序模板
```java
   static class Solution {
        private void swap(int[] arr, int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        /**
         * 冒泡排序
         *
         * @param nums array
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
         *
         * @param nums 数组
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
         * 快速排序
         *
         * @param nums 数组
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
            for (int i = 0; i < temp.length; i++) {
                nums[l + i] = temp[i];
            }
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
    }
```