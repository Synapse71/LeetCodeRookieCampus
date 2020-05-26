/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode newHead = compare(index1, index2);
        ListNode node = newHead;
        while(node != null) {
            if (node == index1) {
                index1 = index1.next;
            } else {
                index2 = index2.next;
            }
            node.next = compare(index1, index2);
            node = node.next;
        }
        return newHead;
    }

    private ListNode compare(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else if (node2.val >= node1.val) {
            return node1;
        } else {
            return node2;
        }
    }
}