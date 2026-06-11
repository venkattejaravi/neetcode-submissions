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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while(! q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int qLen = q.size();
            for(int i = 0 ; i < qLen; i++){
                TreeNode node = q.poll();
                if(node != null) {
                    list.add(node.val);
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
            }
            res.add(list.get(list.size() - 1));
        }
        return res;


    }
}
