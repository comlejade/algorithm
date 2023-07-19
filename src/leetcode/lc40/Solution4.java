package leetcode.lc40;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution4 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 默认最小堆，传入参数后，转为最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }

        return res;
    }
}
