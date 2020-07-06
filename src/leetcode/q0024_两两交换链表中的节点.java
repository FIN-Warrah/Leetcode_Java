package leetcode;

public class q0024_两两交换链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            // 用于返回结果
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode curr = head;
            ListNode preNode = dummy;
            while (curr != null && curr.next != null) {
                ListNode node1 = curr;
                ListNode node2 = curr.next;
                // 交换
                preNode.next = node2;
                node1.next = node2.next;
                node2.next = node1;

                preNode = node1;
                curr = node1.next;
            }
            return dummy.next;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            // 结束条件
            if (head == null || head.next == null)
                return head;

            ListNode node1 = head;
            ListNode node2 = head.next;

            // 交换
            node1.next  = swapPairs(node2.next);
            node2.next = node1;

            return node2;
        }
    }
}
