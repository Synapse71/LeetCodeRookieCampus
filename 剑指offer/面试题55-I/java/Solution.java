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
    int maxLevel = 0;
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        maxLevel = 0;
        travelTree(root, stack, 1);
        return maxLevel;
    }

    private void travelTree(TreeNode root, Stack<TreeNode> stack, int level) {
        if (root == null) {
            if (stack.empty()) {
                return;
            }
            TreeNode parent = stack.pop();
            travelTree(parent.right, stack, parent.val + 1);
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
        }
        root.val = level;
        stack.push(root);
        travelTree(root.left, stack, level+1);
    }
}