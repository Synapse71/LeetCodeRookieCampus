/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        ListNode indexB = headB;
        while (indexA != indexB) {
            indexA = indexA == null ? headB : indexA.next;
            indexB = indexB == null ? headA : indexB.next;
        }
        return indexA;
    }
}