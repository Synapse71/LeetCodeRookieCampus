/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode z = null;
        a.next = z;
        while(b.next != null) {
            z = a;
            a = b;
            b = b.next;
            a.next = z;
        }
        b.next = a;
        return b;
    }
}