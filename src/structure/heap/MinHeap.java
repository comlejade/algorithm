package structure.heap;

import structure.Array;

import java.util.Random;

public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MinHeap() {
       data = new Array<E>();
    }

    public MinHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向最小堆中添加元素
    // 先将元素加入到尾部，然后上浮
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 元素上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    // 查看堆中的最小元素
    public E findMin() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMin when heap is empty.");
        }
        return data.get(0);
    }

    // 取出堆中的最小元素
    // 将顶部元素删除，然后下沉
    public E extractMin() {
        E ret = findMin();

        // 将尾部的最大元素放到堆顶
        data.swap(0, data.getSize() - 1);
        // 此时尾部元素最小，将它删除
        data.removeLast();
        // 元素从顶部开始下沉
        siftDown(0);

        return ret;
    }

    // 元素下沉，每次将元素和左右孩子中最小的元素交换位置
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);

            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) > 0) {
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(j)) < 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    // 取出最小元素，并替换成 e
    public E replace(E e) {
        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MinHeap<Integer> minHeap = new MinHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            minHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = minHeap.extractMin();
        }

        // arr 降序排列
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MinHeap completed.");
    }
}
