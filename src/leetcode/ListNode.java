package leetcode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int[] arr) {
      if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("illegal arr");
      }

      this.val = arr[0];
      ListNode cur = this;
      for (int i = 1; i < arr.length; i++) {
        cur.next = new ListNode(arr[i]);
        cur = cur.next;
      }
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
      StringBuilder res = new StringBuilder();
      res.append("ListNode front ");
      ListNode cur = this;
      while(cur != null) {
        res.append(cur.val + "->");
        cur = cur.next;
      }
      res.append("NULL tail");
      return res.toString();
    }
}
