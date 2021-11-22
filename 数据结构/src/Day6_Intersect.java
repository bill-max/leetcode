import java.util.*;

/**
 * @author 李建彤
 */
public class Day6_Intersect {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result;
        result = intersect01(nums1, nums2);
        for (int a:
             result) {
            System.out.print(" "+a+" ");
        }
    }
    //利用hashMap
    public static int[] intersect01(int[] nums1, int[] nums2){
        //优先遍历小的数组
        if (nums1.length> nums2.length){
            return intersect01(nums2, nums1);
        }
        //hashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //map:key(num)-->value(count)
        for (int num:
             nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] result = new int[nums1.length];
        int index=0;
        for (int num:
             nums2) {
            int count=map.getOrDefault(num, 0);
            if (count>0){
                result[index++]= num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

}
