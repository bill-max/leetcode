import java.util.ArrayList;
import java.util.List;

public class OrderedStream_1656 {
    static class OrderedStream {
        String[] array;
        int ptr = 1;

        public OrderedStream(int n) {
            array = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            List<String> ans = new ArrayList<>();
            array[idKey] = value;
            while (ptr < array.length && array[ptr] != null) {
                ans.add(array[ptr]);
                ptr++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "cccc"));
        System.out.println(orderedStream.insert(1, "aaaa"));
        System.out.println(orderedStream.insert(2, "bbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}
