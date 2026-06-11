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
    int maxSum = Integer.MIN_VALUE;
    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        if(root.left != null && root.right != null) {
            int leftSum = dfs(root.left);
            int rightSum = dfs(root.right);
            maxSum = Math.max(maxSum, root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0));
            return root.val + Math.max(Math.max(leftSum, rightSum), 0);
        }

        if(root.left != null && root.right == null) {
            int leftSum = dfs(root.left);
            maxSum = Math.max(maxSum, root.val + Math.max(leftSum, 0));
            return root.val + Math.max(leftSum, 0);
        }

        if(root.left == null && root.right != null) {
            int rightSum = dfs(root.right);
            maxSum = Math.max(maxSum, root.val + Math.max(rightSum, 0));
            return root.val + Math.max(rightSum, 0);
        }
        return 0;

    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}
