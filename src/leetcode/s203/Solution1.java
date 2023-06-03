package leetcode.s203;

public class Solution1 {
  public ListNode removeElements(ListNode head, int val) {
    // 不使用头部虚拟节点
    // 那么就需要先处理头部节点，再处理后面的节点
    while (head != null && head.val == val) {
      ListNode delNode = head;
      head = delNode.next;
      delNode.next = null;
    }
    if (head == null) return null;
    // 处理后面的节点
    ListNode prev = head;
    while (prev.next != null) {
      if (prev.next.val == val) {
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
      } else {
        prev = prev.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,6,3,4,5,6};
    ListNode head = new ListNode(nums);
    System.out.println(head);
    ListNode res = new Solution1().removeElements(head, 6);
    System.out.println(res);
  }
}
