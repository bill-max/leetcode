public class Day8_MoveZeroes {
    public static void main(String[] args) {
        int[] a={0,1,0,3,0};
        moveZeroes(a);
        for (int e:
             a) {
            System.out.print(" "+e+" ");
        }
    }
    public static void moveZeroes(int[] nums){
        int j= 0;
        int temp = 0;
        for (int i=0;i< nums.length;i++){
            if (nums[i]!=0){
                temp=nums[i];
                nums[i]=0;
                nums[j++]=temp;
            }
        }
    }
}
