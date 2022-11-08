# 剑指offer 笔记

## 03 - 查找重复元素

### idea 1

    利用HashSet

#### code

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }
}
```

#### 复杂度

time:O（n）

space:O（n）

### idea 2

题目说明尚未被充分使用，即 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内.
此说明含义：数组元素的 索引和值是一对多的关系。
因此，可遍历数组并通过交换操作，使元素的 索引与值一一对应（即 nums[i] = inums[i]=i ）。因而，就能通过索引映射对应的值，起到与字典等价的作用。

#### code

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
```

### 复杂度

time:O（n）

space:O（1）

## 05 - 字符串替换

1. str.replace(String oldChar, String newChar):
    * replace() 方法会将字符串中所有 oldChar 替换成 newChar
2. str.replaceFirst(String regex, String replacement):
    * 其中，regex 表示正则表达式；replacement 表示用于替换的字符串。
3. str.replace(String oldChar, String newChar):
    * 其中，regex 表示正则表达式，replacement 表示用于替换的字符串.

## 06-反向打印列表

**核心思路**
回溯，先走到尾节点，然后依次回溯遍历各节点，打印值
**code**

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

**API补充**
Integer[]、 int[]、 List < Integer >互相转换

```
int[] array：

Integer[] integers=Arrays.stream(array).boxed().toArray(Integer[]::new)
List<Integer> list=Arrays.stream(array).boxed().collect(Collectors.toList())

List<Integer> list：

int[] array=list.stream().mapToInt(Integer::intValue).toArray()
Integer[] integers=list.toArray(new Integer[0])

Integer[] integers：

int[] array=Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
List<Integer> list = Arrays.asList(integers);

```

## 09 用两个栈模拟队列

输入数据放入到输入栈。
在要删除队头元素的时候，直接将输入栈全弹出到输出栈，此时栈尾元素就是队头。

## 15 位运算

判断一个数的汉明重量

1. 循环检查:将 n 与 2i 相与，检查每一位上是否为1

```java
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
```

2. api: `Integer.bitCount(n)`

3. 分治法

```
public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
```

## 32 层序遍历

Queue的api

- add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
- offer_50 添加一个元素并返回true 如果队列已满，则返回false

- remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
- poll 移除并返问队列头部的元素 如果队列为空，则返回null

- element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
- peek 返回队列头部的元素 如果队列为空，则返回null

- put 添加一个元素 如果队列满，则阻塞
- take 移除并返回队列头部的元素 如果队列为空，则阻塞

## 40 topK问题

**快排模板**

```java
class Solution {
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;//找到从右开始 第一个 小于 基准的数
            while (i < j && arr[i] <= arr[l]) i++;//找到从左开始 第一个 大于 基准的数
            swap(arr, i, j);//交换两个位置
        }
        swap(arr, i, l);//交换 i 和 基准 的位置  ；此时，基准左边的都小于基准，基准右边的都大于基准
        //分治
        quickSort(arr, l, i - 1);//排基准左边
        quickSort(arr, i + 1, r);//排基准右边
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
```

**堆模板**
大根堆(前 K 小) / 小根堆（前 K 大),
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
        Queue<Integer> heap = new PriorityQueue<>(k,(i1, i2) -> i2 - i1);

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer_50(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        return heap.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
## 51 归并排序模板
```java
class Solution {
   int count;
   public int reversePairs(int[] nums) {
      this.count = 0;
      merge(nums, 0, nums.length - 1);
      return count;
   }

   public void merge(int[] nums, int left, int right) {
      int mid = left + ((right - left) >> 1);
      if (left < right) {
         merge(nums, left, mid);
         merge(nums, mid + 1, right);
         mergeSort(nums, left, mid, right);
      }
   }

   public void mergeSort(int[] nums, int left, int mid, int right) {
      int[] temparr = new int[right - left + 1];
      int index = 0;
      int temp1 = left, temp2 = mid + 1;

      while (temp1 <= mid && temp2 <= right) {
         if (nums[temp1] <= nums[temp2]) {
            temparr[index++] = nums[temp1++];
         } else {
            //用来统计逆序对的个数
            count += (mid - temp1 + 1);
            temparr[index++] = nums[temp2++];
         }
      }
      //把左边剩余的数移入数组
      while (temp1 <= mid) {
         temparr[index++] = nums[temp1++];
      }
      //把右边剩余的数移入数组
      while (temp2 <= right) {
         temparr[index++] = nums[temp2++];
      }
      //把新数组中的数覆盖nums数组
      for (int k = 0; k < temparr.length; k++) {
         nums[k + left] = temparr[k];
      }
   }
}
```

## 53 二分模板
```java
class Solution{
   public int binarySearch(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (target>=nums[mid]) l = mid + 1;
         else r = mid - 1;
      }
      return l;
   }
}
```