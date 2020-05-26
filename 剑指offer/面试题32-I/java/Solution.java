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
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, List<Integer>> nodesMap = childLeaves(root, 0);
        List<Integer> nodes = new ArrayList<>();
        for (List<Integer> nodeList: nodesMap.values()) {
            nodes.addAll(nodeList);
        }
        int length = nodes.size();
        int[] result = new int[length];
        for (int index = 0; index < length; index++) {
            result[index] = nodes.get(index);
        }
        return result;
    }

    private Map<Integer, List<Integer>> childLeaves(TreeNode node, int level) {
        Map<Integer, List<Integer>> current = new TreeMap<>();
        List<Integer> currentLevel = new ArrayList<>();
        currentLevel.add(node.val);
        current.put(level, currentLevel);
        if (node.left != null) {
            Map<Integer, List<Integer>> leftNodes = childLeaves(node.left, level+1);
            for (Map.Entry<Integer, List<Integer>> entry: leftNodes.entrySet()) {
                current.merge(entry.getKey(), entry.getValue(), (oldList, newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                });
            }
        }
        if (node.right != null) {
            Map<Integer, List<Integer>> rightNodes = childLeaves(node.right, level+1);
            for (Map.Entry<Integer, List<Integer>> entry: rightNodes.entrySet()) {
                current.merge(entry.getKey(), entry.getValue(), (oldList, newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                });
            }
        }
        return current;
    }
}