package leetcode.s875;

import java.util.Arrays;

public class Solution {
  // eatingTime(k) <= h 
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = Arrays.stream(piles).max().getAsInt();
    while (l < r) {
      int mid = l + (r - l) / 2;

      if (eatingTime(piles, mid) <= h) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }

    return l;
  }

  // k 吃香蕉的速度
  private int eatingTime(int[] piles, int k) {
    int res = 0;
    for (int pile : piles) {
      res += pile / k + (pile % k > 0 ? 1 : 0);
    }
    return res;
  }
}
