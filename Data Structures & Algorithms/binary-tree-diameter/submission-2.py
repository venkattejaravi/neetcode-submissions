# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    max_depth = 0

    def dfs(self, root):
        if not root:
            return 0

        left_depth  = self.dfs(root.left)
        right_depth = self.dfs(root.right)
        self.max_depth = max(self.max_depth, left_depth + right_depth)

        return 1 + max(left_depth, right_depth)

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.max_depth
    
