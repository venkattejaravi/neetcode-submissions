# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    o_list = []
    def dfs(self, root):
            if not root:
                return

            self.dfs(root.left)
            self.o_list.append(root.val)
            self.dfs(root.right)
            

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.o_list = []
        self.dfs(root)

        if self.o_list:
            for i in range(1, len(self.o_list)):
                if(self.o_list[i] <= self.o_list[i - 1]):
                    return False

        return True
