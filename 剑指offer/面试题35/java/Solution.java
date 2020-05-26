/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node dupHead = new Node(head.val);
        Node dupCur = dupHead;
        map.put(head, dupHead);
        Node cur = head.next;
        while (cur != null) {
            dupCur.next = new Node(cur.val);
            map.put(cur, dupCur.next);
            cur = cur.next;
            dupCur = dupCur.next;
        }
        dupCur = dupHead;
        cur = head;
        while (cur != null) {
            dupCur.random = map.get(cur.random);
            cur = cur.next;
            dupCur = dupCur.next;
        }
        return dupHead;
    }
}