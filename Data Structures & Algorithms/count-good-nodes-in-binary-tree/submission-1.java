/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int count;
    public Solution() {
        this.count = 0;
    }

    public void dfs(TreeNode root, int maxVal) {
        if(root == null) return;
        if(root.val >= maxVal) {
            maxVal = root.val;
            count++;
        }
        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }

    public int goodNodes(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        dfs(root, maxVal);
        return count;
    }
}
