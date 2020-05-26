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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> nodesMap = childLeaves(root, 0);
        for (Map.Entry<Integer, List<Integer>> level: nodesMap.entrySet()) {
            if (level.getKey() % 2 == 1) {
                Collections.reverse(level.getValue());
            }
        }
        result.addAll(nodesMap.values());
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