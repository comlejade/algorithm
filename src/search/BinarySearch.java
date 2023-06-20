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

    // 非递归实现二分查找
    // 修改循环不变量的定义
    public static <E extends Comparable<E>> int search2(E[] data, E target) {
        // 循环不变量的定义发生改变，r的初始值也要变化
        int l = 0, r = data.length;

        // 循环不变量, target 还在 arr[l, r) 的范围内
        // 循环不变量改变，循环条件也发生改变
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;    // 继续在 data[mid + 1, r) 范围里寻找
            } else {
                r = mid; // 继续在 data[l, mid) 的范围里寻找
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

    // 求大于 target 的最小值的索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        // 最后一个值有可能不符合条件，因为二分搜索是在有序的数组中进行
        // 当最后一个索引的值不符合条件，那么只能返回的应该是比最后一个索引还要往后的一个值，
        // 所以此时返回的应该是 data.length
        int l = 0, r = data.length;

        // 在 data[l, r] 中寻找解
        // 当 l == r 的时候，l 一定是问题的解，不管 l 存不存在
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            }

            // r 这里不能等于mid - 1, 因为 r也可能是问题的解
            // 比如 target 是大于60的最小值，那么此时data[mid] > target也是符合条件的
            // 只不过可能左边存在比mid更合适的值，也可能不存在，所以这里的mid不能丢弃
            else {
                r = mid;
            }
        }

        return l;
    }

    // 用求解 >= target 的最小值的索引的方法，实现 search
    public static <E extends Comparable<E>> int search3(E[] data, E target) {
        int l = 0, r = data.length;
        
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        // 因为这里要查找准确的值，所以只判断等于0的情况，如果不相等说明没有，直接返回-1
        if (l < data.length && data[l].compareTo(target) == 0) {
            return l;
        }
        return -1;
    }

    // > target 返回最小索引值
    // == target 返回最大索引
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        // 获取到大于 target 的最小值
        int u = upper(data, target);

        // 那么data[u - 1]如果存在，那么一定是等于 target
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }

        return u;
    }

    // > target 返回最小索引
    // == target 返回最小索引
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0, r = data.length;

        while (l < r) {
            int mid = l + (r - l ) / 2;

//            if (data[mid].compareTo(target) == 0) {
//                r--;
//            }
            // arr[mid] == target 可能是解，但是也有可能解在左边，所以更新右边界
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }

        return l;
    }

    // < target 取最大值索引
    public static <E extends Comparable<E>> int lower(E[] data, E target) {

        int l = - 1, r = data.length - 1;

        while (l < r) {
            // l 和 r 相邻时，可能会陷入死循环，比如 l = 0, r = 1
            // m = 0 + (1 - 0) / 2 = 0
            // arr[0] < arr[1]
            // l = m = 0, 陷入死循环
            // 解决方案：m = l + (r - l + 1) / 2 向上取整
            int mid = l + (r - l + 1) / 2;

            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    // < target 返回最大值的索引
    // == target 返回最小值的索引
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    // <= target 返回最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
        int l = -1, r = data.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
      Integer[] arr = {1, 1, 3, 3, 5, 5};
      for(int i = 0; i <= 6; i++) {
          System.out.print(BinarySearch.lower(arr, i) + " ");
      }
    }
}
