public class day2_deleteArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 5};
        int result = 0;
        result = removeDuplicates(nums);
        System.out.println(result);
        for (int a :
                nums) {
            System.out.print(a);
        }
    }

    public static int removeDuplicates(int[] nums) {
/*        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count] = nums[i + 1];
                count++;
            }
        }
        return count;
    }*/
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}