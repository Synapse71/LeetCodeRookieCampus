/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode current = head;
        while (current.next != null && current.next.val != val) {
            current = current.next;
        }
        ListNode target = current.next;
        current.next = target.next;
        return head;
    }
}