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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new LinkedList<>();
        List<Integer> inList = new LinkedList<>();
        for (int item : preorder) {
            preList.add(item);
        }
        for (int item : inorder) {
            inList.add(item);
        }
        return buildTree(preList, inList);
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder == null || preorder.size() == 0 || inorder == null || inorder.size() == 0) {
            return null;
        }
        int rootValue = preorder.get(0);
        TreeNode node = new TreeNode(rootValue);
        int rootIndex = inorder.indexOf(rootValue);
        List<Integer> leftInorder = inorder.subList(0, rootIndex);
        List<Integer> rightInorder = inorder.subList(rootIndex+1, inorder.size());
        List<Integer> leftPreorder = preorder.subList(1, leftInorder.size() + 1);
        List<Integer> rightPreorder = preorder.subList(leftInorder.size() + 1, inorder.size());
        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);
        return node;
    }
}