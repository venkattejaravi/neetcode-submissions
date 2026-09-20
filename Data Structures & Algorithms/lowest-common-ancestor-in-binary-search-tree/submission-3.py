# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        from collections import deque

        queue = deque([root])

        while queue:
            node = queue.popleft()
            
            if(p.val < node.val and q.val < node.val):
                if(node.left):
                    queue.append(node.left)

            elif(p.val > node.val and q.val > node.val):
                if(node.right):
                    queue.append(node.right)
            else:
                return node

        return
