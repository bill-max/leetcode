# 滑动窗口

3-最大不重复子串长度
**核心：使用map记录每个点出现的位置**

```java
static class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
```

# 二分查找模板

**核心**：明确区间是开闭情况，while中判断条件取决于你最后想让指针落在哪个位置。

左闭右闭

```java
class Solution {
    public int find(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

左闭右开

```java
class Solution {
    public int find(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

# 回溯
## 模板
```java
class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        dfs(n, k, subset, 1);
        return ans;
    }

    private void dfs(int n, int k, List<Integer> subset, int i) {
        if (i > n + 1 || subset.size() + (n - i + 1) < k) return;//剪枝
        if (subset.size() == k) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(i);
        dfs(n, k, subset, i + 1);
        subset.remove(subset.size() - 1);
        dfs(n, k, subset, i + 1);
    }
}
```


# 位运算

## 统计二进制中1的个数

### 经典模板

```java
class Solution {
    public int count(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }
        return cnt;
    }
}
```

### 最优

```java
class Solution {
    public int count(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
```

### api

```java
class Solution {
    public int count(int n) {
        return Integer.bitCount(n);
    }
}
```

# 排序

## 经典排序模板

```java
class Solution {
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

## TopK问题

### 堆模板

大根堆(前 K 小) / 小根堆(前 K 大),
对于堆来讲，每次删除的都是堆顶元素

小根堆queue.peek()返回的是最小元素
大根堆queue.peek()返回的是最大元素

```java
// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于K，将当前数字放入堆中。
// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

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
```

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
        if (head == null || head.next == null) return null;
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

## 反向打印列表：回溯

回溯，先走到尾节点，然后依次回溯遍历各节点，打印值

```java
 static class Solution {
    int[] res;
    int i = 0, j = 0;

    public int[] reversePrint(ListNode head) {
        help(head);
        return res;
    }

    public void help(ListNode node) {
        if (node == null) {
            res = new int[i];
            return;
        }
        i++;
        help(node.next);
        res[j++] = node.val;
    }
}

```

# 常用API

## Integer[]、 int[]、 List\<Integer>互相转换

```java
class Convert {
//int[] array：

   Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
   List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

//List<Integer> list：

   int[] array = list.stream().mapToInt(Integer::intValue).toArray();
   Integer[] integers = list.toArray(new Integer[0]);

//Integer[] integers：

   int[] array = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
   List<Integer> list = Arrays.asList(integers);
}
```

## 字符串

1. str.replace(String oldChar, String newChar):
   * replace() 方法会将字符串中所有 oldChar 替换成 newChar
2. str.replaceFirst(String regex, String replacement):
   * 其中，regex 表示正则表达式；replacement 表示用于替换的字符串。
3. str.replace(String oldChar, String newChar):
   * 其中，regex 表示正则表达式，replacement 表示用于替换的字符串.

## Queue

- add 增加一个元索 如果队列已满，则抛出一个IllegalISlabAppliance异常
- offer 添加一个元素并返回true 如果队列已满，则返回false
- remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
- poll 移除并返问队列头部的元素 如果队列为空，则返回null
- element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
- peek 返回队列头部的元素 如果队列为空，则返回null
- put 添加一个元素 如果队列满，则阻塞
- take 移除并返回队列头部的元素 如果队列为空，则阻塞
