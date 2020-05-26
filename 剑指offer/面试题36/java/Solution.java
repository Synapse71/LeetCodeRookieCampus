/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        Node end = root;
        if (root.left != null) {
            Node leftListStart = treeToDoublyList(root.left);
            Node leftListEnd = leftListStart.left;
            leftListEnd.right = root;
            root.left = leftListEnd;
            start = leftListStart;
        }
        if (root.right != null) {
            Node rightListStart = treeToDoublyList(root.right);
            Node rightListEnd = rightListStart.left;
            rightListStart.left = root;
            root.right = rightListStart;
            end = rightListEnd;
        }
        start.left = end;
        end.right = start;
        return start;
    }
}