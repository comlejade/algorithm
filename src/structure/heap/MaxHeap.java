package structure.heap;

import structure.Array;

import java.util.Random;

/**
 * 完全二叉树
 * 最大堆
 * 完全二叉树不会出现只有一侧子树的情况，因此算法不会退化到O(n)
 * add 和 extractMax 时间复杂度都是O(logn)
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        // 将一个数组转成堆
        data = new Array<>(arr);
        // 从最后一个非叶子节点开始向上执行siftDown操作
        // 结束之后就可以获得一个二叉堆
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 元素上浮，对于完全二叉树，父节点都是大于等于孩子节点的，因此，拿与父节点元素比较，
    // 如果比父节点大那么这个元素就上浮，在数组中就是交换两个元素的位置
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 查看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }

        return data.get(0);
    }

    // 取出堆中的最大元素
    public E extractMax() {
        E ret = findMax();
        // 将堆中最小的元素（即堆中最后一个元素）放到堆顶
        data.swap(0, data.getSize() - 1);
        // 将堆的最后一个元素删除
        data.removeLast();
        // 堆的性质改变，因此需要将堆顶的元素下沉到合适的位置
        siftDown(0);

        return ret;
    }

    // 元素下沉
    // 每次将k位置元素和左右孩子节点中最大的那个值交换位置
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 获取左孩子索引
            int j = leftChild(k);

            // 如果左孩子的值小于右孩子的值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
               j = rightChild(k);
            }

            // 上面找到了左右两个孩子中的最大值，索引为 j，如果 data.get(k) 处的值大于等于 data.get(j)
            // 那么data.get(k)已经在合适的位置了
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            // 如果不符合上面的条件，就交换k和子树中最大值j的位置
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        // arr 降序排列
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }
}
