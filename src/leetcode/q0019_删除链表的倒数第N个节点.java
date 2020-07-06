package leetcode;

public class q0019_删除链表的倒数第N个节点 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 在头节点之前的指针，用于返回结果
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            // 两个节点指针
            ListNode firstPointer = dummyHead;
            ListNode secondPointer = dummyHead;
            // 先移动第一个指针
            for (int i = 0; i < n; i++) {
                firstPointer = firstPointer.next;
            }
            // 然后两个指针一起移动
            while (firstPointer.next != null) {
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            }
            // 删除第二个指针指向的节点
            secondPointer.next = secondPointer.next.next;

            return dummyHead.next;
        }
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
