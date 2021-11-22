public class day4_RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        /*//向右旋转数组(双数组）
        int n = nums.length;
        int[] result = new int[n];
        k%=n;
        for (int i = 0; i < n; i++) {
            if (k%n == 0) {
                k = 0;
            }
            result[k++] = nums[i];
        }
        System.arraycopy(result,0,nums,0,n);
        for (int a :
                nums) {
            System.out.print(" " + a + "");
        }*/
        //数组翻转
        int n= nums.length;
        k%=n;
        if (n>1) {
            reverse(nums, 0, n-1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n-1);
            for (int a :
                    nums) {
                System.out.print(" " + a + "");
            }
        }
    }
    private static void reverse(int[] array,int begin,int end){
        int temp;
        while (begin<end){
            temp=array[begin];
            array[begin]=array[end];
            array[end]=temp;
            begin++;
            end--;
        }
    }

}
