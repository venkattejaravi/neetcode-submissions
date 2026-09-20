# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        from collections import deque

        q  = deque()
        q.append((root, float("-inf"), float("inf")))
        

        while q:
            packet = q.popleft()
            node = packet[0]
            lower = packet[1]
            upper = packet[2]
            
            if not (node.val > lower and node.val < upper ):
                return False

            if node.left:
                q.append((node.left, lower, node.val))
            if node.right:
                q.append((node.right, node.val, upper))

        return True
