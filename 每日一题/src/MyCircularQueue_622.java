import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MyCircularQueue_622 {
    static class MyCircularQueue {
        private final int[] queue;
        private final int size;
        private int front;
        private int last;

        public MyCircularQueue(int k) {
            size = k + 1;
            front = last = 0;
            queue = new int[size];
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            queue[last] = value;
            last = (last + 1) % size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % size;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return queue[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return queue[(last - 1 + size) % size];
        }

        public boolean isEmpty() {
            return front == last;
        }

        public boolean isFull() {
            return ((last + 1) % size) == front;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);
        Queue<Integer> queue1 = new ArrayDeque<>();
    }
}
