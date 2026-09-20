# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def dfs(self, root, lower, upper):
        if not root:
            return True

        if not (root.val > lower and root.val < upper):
            return False

        return self.dfs(root.left, lower,root.val) and self.dfs(root.right, root.val, upper)


    def isValidBST(self, root: Optional[TreeNode]) -> bool:
	    return self.dfs(root, float('-inf'), float('inf'))

    
        