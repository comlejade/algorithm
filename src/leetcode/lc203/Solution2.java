package leetcode.lc203;

import leetcode.ListNode;

public class Solution2 {
  public ListNode removeElements(ListNode head, int val) {
    // 使用头部虚拟节点
    ListNode dummyHead = new ListNode(0, head);
    ListNode prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.val == val) {
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
      } else {
        prev = prev.next;
      }
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,6,3,4,5,6};
    ListNode head = new ListNode(nums);
    System.out.println(head);
    ListNode res = new Solution1().removeElements(head, 6);
    System.out.println(res);
  }
}
