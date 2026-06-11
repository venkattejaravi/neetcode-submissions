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
    private int preIndex;
    private Map<Integer, Integer> mids;
    public Solution() {
        this.preIndex = 0;
        this.mids = new HashMap<>();
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) mids.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int mid = mids.get(root.val);
        root.left = helper(preorder, inStart, mid - 1);
        root.right = helper(preorder, mid + 1, inEnd);
        return root;
    }
}
