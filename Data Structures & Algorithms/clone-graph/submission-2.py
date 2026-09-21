"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors else []
"""

class Solution:
    clone_to_original = defaultdict(Node)

    def dfs(self, node):
        if not node:
            return

        dupNode = Node()
        dupNode.val = node.val
        dupNode.neighbors = []

        self.clone_to_original[node] = dupNode

        for neighbor in node.neighbors:
            if neighbor in self.clone_to_original:
                dupNode.neighbors.append(self.clone_to_original[neighbor])
            else:
                dupNode.neighbors.append(self.dfs(neighbor))
        
        return dupNode

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        self.clone_to_original = defaultdict(Node)
        return self.dfs(node)
