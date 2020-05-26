/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        reflect(root.right);
        return equals(root.left, root.right);
    }

    private void reflect(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        reflect(node.left);
        reflect(node.right);
    }

    private boolean equals(TreeNode treeA, TreeNode treeB) {
        if (treeA == null && treeB == null) {
            return true;
        }
        if (treeA == null || treeB == null) {
            return false;
        }
        if (treeA.val != treeB.val) {
            return false;
        }
        return equals(treeA.left, treeB.left) && equals(treeA.right, treeB.right);
    }
}