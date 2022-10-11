import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class LargestNumber_179 {
    static class Solution {
        public String largestNumber(int[] nums) {
            Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(array, (o1, o2) -> {
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);
                return (str2 + str1).compareTo(str1 + str2);
            });
            /*Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String str1 = String.valueOf(o1);
                    String str2 = String.valueOf(o2);
                    return (str2 + str1).compareTo(str1 + str2);
                }
            });*/
            if (array[0] == 0) return "0";
            return Arrays.stream(array).map(Object::toString).collect(Collectors.joining(""));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10, 2}));
    }
}
