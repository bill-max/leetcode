import java.util.PriorityQueue;
import java.util.Queue;

public class offer_41 {
    static class MedianFinder {

        /* initialize your data structure here. */
        /**
         * 维护一个  大根堆、 一个 小根堆 各保存列表一半元素
         * 如果 m+n 是偶数 那就各取一个/2
         * 否则就取多的那一个
         *
         * 对于堆来讲，删除的都是堆顶的元素
         */
        Queue<Integer> A, B;
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {

            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < 6; i++) {
            medianFinder.addNum(i);
        }
    }

}
