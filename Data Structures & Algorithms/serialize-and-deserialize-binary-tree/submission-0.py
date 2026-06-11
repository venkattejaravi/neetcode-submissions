# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""

        # BFS
        res = []
        queue = collections.deque([root])

        while queue:
            node = queue.popleft()
            if node:
                res.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            else:
                res.append("N")

        return ','.join(res)

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if not len(data):
            return None
            
        data = data.split(',')
        if data[0] == "N":
            return None
        root = TreeNode(int(data[0]))
        queue = collections.deque([root])
        index = 1
        while queue:
            node = queue.popleft()
            if data[index] != "N":
                node.left = TreeNode(int(data[index]))
                queue.append(node.left)
            index += 1
            if data[index] != "N":
                node.right = TreeNode(int(data[index]))
                queue.append(node.right)
            index += 1

        return root












