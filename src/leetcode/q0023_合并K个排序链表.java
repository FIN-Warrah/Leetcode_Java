package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class q0023_合并K个排序链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // 用来返回结果
            ListNode dummy = new ListNode(-1);
            ListNode pointer = dummy;
            while (true) {
                ListNode minNode = null;
                int minIndex = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] == null) continue;
                    if (minNode == null || lists[i].val < minNode.val) {
                        minNode = lists[i];
                        minIndex = i;
                    }
                }
                // 完成
                if (minIndex == -1)
                    break;
                pointer.next = minNode;
                pointer = pointer.next;
                lists[minIndex] = lists[minIndex].next;
            }
            return dummy.next;
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            // 用来返回结果
            ListNode dummy = new ListNode(-1);
            ListNode pointer = dummy;
            // 优先队列
            Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for (ListNode node : lists) {
                if (node != null)
                    pq.offer(node);
            }
            // 循环
            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                pointer.next = minNode;
                pointer = pointer.next;
                if (minNode.next != null)
                    pq.offer(minNode.next);
            }
            return dummy.next;
        }
    }

    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            // 调用helper函数
            return helper(lists, 0, lists.length - 1);
        }

        private ListNode helper(ListNode[] lists, int begin, int end) {
            // 如果是同一个链表
            if (begin == end)
                return lists[begin];
            // 分治
            int mid = begin + (end - begin) / 2;
            ListNode left = helper(lists, begin, mid);
            ListNode right = helper(lists, mid + 1, end);
            return merge(left, right);
        }

        // 合并两个有序链表，这里使用递归方式实现
        private ListNode merge(ListNode left, ListNode right) {
            if (left == null || right == null)
                return left == null ? right : left;
            if (left.val < right.val) {
                left.next = merge(left.next, right);
                return left;
            } else {
                right.next = merge(left, right.next);
                return right;
            }
        }
    }
}
