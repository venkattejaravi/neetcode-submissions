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

public class Codec {
    List<String> resArr = new ArrayList<>();
    String[] dataArr;
    int i = 0;
    
    public void dfs(TreeNode root) {
        if(root == null) {
            resArr.add("N");
            return;
        }
        resArr.add(Integer.toString(root.val));
        dfs(root.left);
        dfs(root.right);   
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        dfs(root);
        String res = String.join(",", resArr);
        return res;
    }

    // helper dfs for deserialize
    public TreeNode dfs() {
        String val = dataArr[i++];
        if(val.equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs();
        root.right = dfs();
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data : " + data);
        if(data.length() == 0) return null;
        dataArr = data.split(",");
        return dfs();
    }
}
