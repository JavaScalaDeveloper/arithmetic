package jz_offer.src.medium.JZ63;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {
    private List<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(100);
        MedianFinder solution = new Solution.MedianFinder();
        int[] arr = {1, 3, 2, 5, 6, 4, 9, 8};
        for (int i : arr) {
            solution.addNum(i);
            System.out.println("maxHeap:"+solution.maxHeap);
            System.out.println("minHeap:"+solution.minHeap);
        }
        double median = solution.findMedian();
        System.out.println(median);
    }
    public void insert(Integer num) {
        list.add(num.doubleValue());
        Collections.sort(list);
    }

    public Double getMedian() {
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }
    }


    /**
     * 使用两个堆来解决这个问题。假设数据流中已经有了n个数，其中前n/2个数被插入到了一个小根堆中，而后n/2个数被插入到了一个大根堆中。
     *
     * 对于一个新流进来的数num，首先判断两个堆中元素的个数是否相等，如果相等，则说明当前是偶数个数值，中位数应该是小根堆中最小值和大根堆中最大值的平均数；如果不相等，则说明当前是奇数个数值，中位数直接就是小根堆中的最小值或大根堆中的最大值。
     *
     * 然后，我们将num放入合适的堆中：如果num比小根堆中的最小值还小，则应该放入小根堆中；否则应该放入大根堆中。
     *
     * 当我们完成num的插入之后，可能会出现小根堆中元素多于大根堆（或者少于大根堆）的情况，此时需要进行平衡操作：将小根堆中的最小值取出，并插入到大根堆中；或者将大根堆中的最大值取出，并插入到小根堆中。
     */
    static class MedianFinder {
        private PriorityQueue<Integer> minHeap; // 小根堆
        private PriorityQueue<Integer> maxHeap; // 大根堆

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.size() == maxHeap.size()) { // 偶数个
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
            } else { // 奇数个
                if (num >= minHeap.peek()) {
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                }
            }
            balance(); // 平衡操作
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) { // 偶数个
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            } else { // 奇数个
                return (double) minHeap.peek();
            }
        }

        private void balance() {
            while (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }

        }
    }

}
