class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode thisNode = head;
        ListNode kthNode = head;
        for(int i = 0; i < k; i++) {
            kthNode = kthNode.next;
        }
        while(kthNode != null) {
            thisNode = thisNode.next;
            kthNode = kthNode.next;
        }
        return thisNode;
    }
}