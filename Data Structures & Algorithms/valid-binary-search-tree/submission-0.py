# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(node, leftMin, rightMax):
            if not node:
                return True

            if not (leftMin < node.val < rightMax):
                return False

            return isValid(node.left, leftMin, node.val) and isValid(node.right, node.val, rightMax)

        return isValid(root, float("-inf"), float("inf"))