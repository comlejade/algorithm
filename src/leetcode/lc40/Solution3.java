package leetcode.lc40;

import structure.queue.PriorityQueue;

/**
 * 使用优先队列实现
 */
public class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue();
        }
        return res;
    }
}
