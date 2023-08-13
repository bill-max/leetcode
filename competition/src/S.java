import java.util.*;

public class S {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        q.add(2);
        q.add(1);
        q.add(3);
        q.add(4);
        for (Integer integer : q) {
            System.out.println(integer);
        }
    }


}
