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

## 二叉树

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

## 多叉树

```java
static class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> set = new ArrayList<>();
        dfs(candidates, target, 0, set);
        return ans;
    }

    private void dfs(int[] candidates, int target, int cur, List<Integer> set) {
        if (target == 0) {
            ans.add(new ArrayList<>(set));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (target < 0) return;//剪枝
            if (i > cur && candidates[i] == candidates[i - 1]) continue; //剪枝
            set.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, set);
            set.remove(set.size() - 1);
        }
    }
}
```

## 剪枝

```java
class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> set = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, vis, 0);
        return ans;
    }

    private void dfs(int[] nums, boolean[] vis, int cnt) {
        if (cnt == nums.length) {
            ans.add(new ArrayList<>(set));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;//剪枝
            set.add(nums[i]);
            vis[i] = true;
            dfs(nums, vis, cnt + 1);
            set.remove(set.size() - 1);
            vis[i] = false;
        }
    }
}
```

### 同层剪枝

当选取到nums[i]，并满足 i > 0 && nums[i - 1] == nums[i] 时，若 !visited[i - 1] = true，
说明以nums[i - 1]为某一层元素的选择已穷尽，以至于在回溯的时候置 visited[i - 1] = false）。于是后续会根据这个条件跳过同层相等元素。

### 非同层剪枝

最后一个子条件若采用 visited[i - 1]，当选取到nums[i]，并满足 i > 0 && nums[i - 1] == nums[i] 时，若 visited[i - 1] = true，
表明当前是在nums[i - 1]的子树中选择nums[i]，根据这个条件，在子树中遇到nums[i]，总是不选取（continue），
那么该子树总是无法提供有效排列（因为缺少nums[i]），于是对该子树的搜索都是无效的。
之后回溯到nums[i - 1]所在层后，由于撤销为 visited[i - 1] = false，不再满足visited[i - 1] = true，于是不会跳过，
可以正常选取到包含nums[i - 1]和nums[i]的排列。

通过上述说明，采用!visited[i - 1]的「同层剪枝」效率更高，因为「非同层剪枝」对nums[i - 1]的子树（存在nums[i] == nums[i - 1]
）的搜索是无效的。另外我们也可以看到，无论哪一种，输出有效排列的顺序是一致的。二者的差别可理解为，非同层剪枝比同层剪枝多做了无效子树搜索动作。

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

# 栈

## 单调栈

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }
}
```

# 图

## 拓扑排序

LeetCode 210 课程排序  
**有向无权图求排列**

### BFS解法

建图时计算每个节点的入度，在添加结果时，先将入度为0的节点加入，加入后，将与之相邻节点的入度-1，如果-1后为0，那就再加入结点。

```java
class SolutionBFS {
    //bfs
    List<List<Integer>> edges;
    int[] indeg;//每个节点的入度
    int[] res;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        res = new int[numCourses];
        index = 0;
        //建图，
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        //将所有入度为0的节点放到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        //bfs
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;
            //遍历与该节点相连的节点
            for (int v : edges.get(u)) {
                //入度减一
                --indeg[v];
                //如果入度为0，说明下次可以添加该节点
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return res;
    }
}
```

### DFS解法

逆向思维，从最先节点开始遍历，依次搜索与之相邻的节点，搜索时检查是否有环，如果有环，则无结果。
搜索到头节点的时候，将该节点入栈，并标记为已完成。

```java
class SolutionDFS {
    //dfs
    List<List<Integer>> edges;
    int[] vis;
    int[] res;

    //栈下标
    int index;

    //判断有向图中是否有环
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //建图
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        vis = new int[numCourses];
        res = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //dfs
        for (int i = 0; i < numCourses && valid; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        //如果有环，则无结果
        if (!valid) return new int[0];
        return res;
    }

    private void dfs(int i) {
        //将节点标记为搜索中
        vis[i] = 1;
        //搜索相邻节点
        //有环就停止
        for (int v : edges.get(i)) {
            if (vis[v] == 0) {
                dfs(v);
                if (!valid) return;
            } else if (vis[v] == 1) {
                valid = false;
                return;
            }
        }
        //将结点标记为已完成
        vis[i] = 2;
        res[index--] = i;
    }
}
```

## 并查集

通常用于找到连通分量的个数

```java
class Solution_set {
    //并查集
    public int findCircleNum(int[][] isConnected) {
        //使用并查集
        //初始化
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }
        //遍历矩阵，合并
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) union(parent, i, j);
            }
        }
        //查询树的数量
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    //合并，将i的根节点指定为j，即将i这棵子树挂在j上
    private void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    //递归查询，只有根节点满足 parent[i]=i
    //每次回归都返回当前节点的父节点(已经被赋值为根节点了，所以每次都返回根节点)
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        else return parent[i] = find(parent, parent[i]);
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
