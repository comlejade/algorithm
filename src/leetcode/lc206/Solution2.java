package leetcode.lc206;

import leetcode.ListNode;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = new Solution2().reverseList(head);
        System.out.println(res);
    }
}
