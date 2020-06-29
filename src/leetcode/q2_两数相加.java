package leetcode;

public class q2_两数相加 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // preHead表示结果链表的头节点的前置节点，通过preHead.next返回结果
            ListNode preHead = new ListNode(0);
            // n1表示第一个链表中当前元素，n2代表第二个链表中当前元素，curr表示结果链表中当前元素
            ListNode n1 = l1, n2 = l2, curr = preHead;
            // carry表示进位
            int carry = 0;
            // 当两个链表有其中一个遍历到末尾时，将两个链表中的对应元素相加
            while (n1 != null || n2 != null) {
                int num1 = n1 == null ? 0 : n1.val;
                int num2 = n2 == null ? 0 : n2.val;
                // 当前位的和
                int currSum = num1 + num2 + carry;
                // 刷新进位
                carry = currSum / 10;
                // 创建下一个节点
                curr.next = new ListNode(currSum % 10);
                // 结果节点后移
                curr = curr.next;
                // 将两个输入链表中的不为null的节点后移
                if (n1 != null)
                    n1 = n1.next;
                if (n2 != null)
                    n2 = n2.next;
            }
            // 循环结束，考虑最后是否添加一位
            if (carry > 0)
                curr.next = new ListNode(carry);
            return preHead.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
