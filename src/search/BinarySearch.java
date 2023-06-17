package search;

/**
 * 对于有序的数组，才能使用二分查找，因此要先排序
 * 不计算排序时间，时间复杂度是 O(logn)
 * 计算排序时间，时间复杂度是O(nlogn)
 * 一次排序，多次查找
 */
public class BinarySearch {
    private BinarySearch() {}

    // 非递归实现二分查找
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        // 循环不变量, target 还在 arr[l, r] 的范围内
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }

            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // 递归实现二分查找
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0) return mid;

        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }

        return searchR(data, l, mid - 1, target);
    }


}
