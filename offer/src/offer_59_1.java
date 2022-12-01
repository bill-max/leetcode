import java.util.*;

public class offer_59_1 {
    static class Solution {
        /**
         * 使用单调栈
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            //单调队列
            //下面是要注意的点：
            //队列按从大到小放入
            //如果首位值（即最大值）不在窗口区间，删除首位
            //如果新增的值小于队列尾部值，加到队列尾部
            //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
            //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
            Deque<Integer> deque = new LinkedList<>();//构造一个单调栈  从底向上依次减小
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                while(!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
            }
            res[0] = deque.peekFirst();
            for(int i = k; i < nums.length; i++) {
                if(deque.peekFirst() == nums[i - k])
                    deque.removeFirst();
                while(!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.peekFirst();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
