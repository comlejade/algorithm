package leetcode.s1011;

import java.util.Arrays;

public class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();

    while (l < r) {
      int mid = l + (r - l) / 2;

      if (getDays(weights, mid) <= days) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return l;
  }

  private int getDays(int[] weights, int wt) {
    int res = 0;
    int cur = 0;
    for (int w : weights) {
      if (cur <= wt) {
        cur += w;
      } else {
        res++;
        cur = w;
      }
    }
    // 最后一天的运载量肯定是小于等于 wt 的值，这里 res没有加 1，所以最后还要加一天
    res++;

    return res;
  }
}
