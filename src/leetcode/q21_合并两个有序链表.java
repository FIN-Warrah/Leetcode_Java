package leetcode;

public class q21_合并两个有序链表 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 头节点之前的节点，用于返回结果
            ListNode dummy = new ListNode();
            // 节点指针
            ListNode pointer = dummy;

            // 在到达一个链表末尾的时候结束循环
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pointer.next = l1;
                    l1 = l1.next;
                } else {
                    pointer.next = l2;
                    l2 = l2.next;
                }
                pointer = pointer.next;
            }

            // 最后将没到达末尾的哪个链表合并进去
            pointer.next = l1 == null ? l2 : l1;

            return dummy.next;
        }
    }
}
