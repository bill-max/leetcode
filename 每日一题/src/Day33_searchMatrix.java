public class Day33_searchMatrix {
    //可以抽象成二叉搜索树
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        //第一行折半
        int[] nums = matrix[0];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            n = left - 1;
        }
        //按列查找
        for (; n >= 0; n--) {
            left = 0;
            right = matrix.length - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target == matrix[mid][n]) {
                    return true;
                } else if (matrix[mid][n] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
