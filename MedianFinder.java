package leetCodeJava;

import java.util.*;

public class MedianFinder {
	
	Queue<Integer> minHeap;
	Queue<Integer> maxHeap;
	
	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	}
	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
	public double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return maxHeap.peek() + (minHeap.peek() - maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}
