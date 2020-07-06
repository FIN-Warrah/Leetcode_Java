package leetcode;

public class q0025_K个一组翻转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode end = dummy;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++)
                    end = end.next;
                if (end == null) break;
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverseSubGroup(start);
                start.next = next;
                pre = start;
                end = pre;
            }
            return dummy.next;
        }

        // 从head翻转到null
        private ListNode reverseSubGroup(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    class Solution2 {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                // 如果剩余数量小于k，则无需反转
                if (tail == null)
                    return head;
                tail = tail.next;
            }
            // 反转前k个元素
            ListNode newHead = reverse(head, tail);
            // 下一轮开始的地方就是tail
            head.next = reverseKGroup(tail, k);

            return newHead;
        }

        private ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode next = null;
            while (head != tail) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
