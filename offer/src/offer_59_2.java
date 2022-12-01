import java.util.*;

public class offer_59_2 {
    static class MaxQueue {
        Deque<Integer> deque;
        Queue<Integer> queue;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new ArrayDeque<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            if (queue.peek().equals(deque.peekFirst()))
                deque.pollFirst();
            return queue.poll();
        }
    }
}
