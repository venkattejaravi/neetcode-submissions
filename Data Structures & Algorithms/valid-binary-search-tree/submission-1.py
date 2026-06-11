# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        queue = collections.deque([(root, float("-inf"), float("inf"))])

        while queue:
            node, leftMin, rightMax = queue.popleft()
            if node:
                if not (leftMin < node.val < rightMax):
                    return False
                queue.append((node.left, leftMin, node.val))
                queue.append((node.right, node.val, rightMax))
        return True


            
