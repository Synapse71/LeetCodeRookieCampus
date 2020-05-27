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
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = tree2list(root);
        return list.get(list.size() - k);
    }

    private List<Integer> tree2list(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(tree2list(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(tree2list(root.right));
        }
        return result;
    }
}