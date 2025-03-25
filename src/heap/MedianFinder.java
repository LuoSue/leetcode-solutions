package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author rj
 * @className MedianFinder
 * @description leetcode 295. 数据流的中位数
 * @date 2025/3/25 11:02
 */
class MedianFinder {
    // 大顶堆，存储较小的一半元素
    private PriorityQueue<Integer> maxHeap;
    // 小顶堆，存储较大的一半元素
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // 初始化大顶堆（使用自定义比较器反转排序）
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 初始化小顶堆（默认升序排序）
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 先将元素加入到大顶堆中
        maxHeap.offer(num);

        // 2. 确保大顶堆的堆顶 <= 小顶堆的堆顶
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        // 3. 平衡两个堆的大小，确保 maxHeap.size() == minHeap.size() 或 maxHeap.size() == minHeap.size() + 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // 如果元素总数为奇数，中位数是大顶堆的堆顶
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        // 如果元素总数为偶数，中位数是两个堆顶的平均值
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 输出 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr = [1, 2, 3]
        System.out.println(medianFinder.findMedian()); // 输出 2.0
    }
}
