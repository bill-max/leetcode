# 剑指offer 笔记
## 03 - 查找重复元素
### idea 1
    利用HashSet
#### code
```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for(int num : nums) {
            if(dic.contains(num)) return num;
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
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
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

