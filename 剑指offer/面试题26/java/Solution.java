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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (compareTreeNode(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compareTreeNode(TreeNode tree, TreeNode subTree) {
        if (subTree == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        if (tree.val != subTree.val) {
            return false;
        }
        return compareTreeNode(tree.left, subTree.left) && compareTreeNode(tree.right, subTree.right);
    }
}