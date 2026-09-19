# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        from collections import deque

        q = deque([root])

        ordered_list = []
        while q:
            node = q.popleft()
            ordered_list.append(node)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

        height = defaultdict(int)
        diameter = 0

        for node in reversed(ordered_list):
            left_height = height[node.left] if node.left else 0
            right_height = height[node.right] if node.right else 0
            
            diameter = max(diameter, left_height + right_height)

            height[node] = 1 + max(left_height, right_height)

        return diameter
