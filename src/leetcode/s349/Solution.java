package leetcode.s349;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    ArrayList<Integer> result = new ArrayList<>();

    for (int num : nums2) {
      if (set.contains(num)) {
        result.add(num);
        set.remove(num);
      }
    }

    int[] res = new int[result.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = result.get(i);
    }

    return res;
  }
}
