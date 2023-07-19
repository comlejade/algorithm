package leetcode.lc206;

import leetcode.ListNode;

public class Solution1 {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = new Solution1().reverseList(head);
        System.out.println(res);
    }
}
