# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    nums = []

    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        self.nums.append(root.val)
        self.dfs(root.right)

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.nums = []
        self.dfs(root)
        return self.nums[k - 1]
