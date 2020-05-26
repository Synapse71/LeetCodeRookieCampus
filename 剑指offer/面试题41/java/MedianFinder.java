class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.add(num);
            return;
        }
        if (maxHeap.size() < minHeap.size()) {
            // 添加到大根堆
            if (num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            // 添加到小根堆
            if (num < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return (double)minHeap.peek();
        }
        if (minHeap.size() == 0) {
            return 0.0;
        }
        return ((double)minHeap.peek() + (double)maxHeap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */