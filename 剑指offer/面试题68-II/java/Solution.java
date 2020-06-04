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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathA = null;
        List<TreeNode> pathB = null;
        List<TreeNode> path = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root == null) {
                TreeNode parent = stack.pop();
                path = path.subList(0, path.indexOf(parent) + 1);
                root = parent.right;
                continue;
            }
            int value = root.val;
            stack.push(root);
            path.add(root);
            if (value == p.val || value == q.val) {
                if (pathA != null) {
                    pathB = new ArrayList<>(path);
                    break;
                } else {
                    pathA = new ArrayList<>(path);
                }
            }
            root = root.left;
        }
        return getLastSameNode(pathA, pathB);
    }

    private TreeNode getLastSameNode(List<TreeNode> a, List<TreeNode> b) {
        if (a == null || b == null) {
            return null;
        }
        int loop = Math.min(a.size(), b.size());
        TreeNode sameNode = null;
        for (int i = 0; i < loop; i++) {
            if (a.get(i).equals(b.get(i))) {
                sameNode = a.get(i);
            } else {
                break;
            }
        }
        return sameNode;
    }
}