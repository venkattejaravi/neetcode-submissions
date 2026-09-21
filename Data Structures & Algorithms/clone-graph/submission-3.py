"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from collections import deque


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        if not node:
            return None

        original_to_dup = defaultdict(Node)
        original_to_dup[node] = Node(node.val)

        q = deque([node])

        while q:
            curr = q.popleft()

            for neighbor in curr.neighbors:
                if neighbor not in original_to_dup:
                    original_to_dup[neighbor] = Node(neighbor.val)
                    q.append(neighbor)

                original_to_dup[curr].neighbors.append(original_to_dup[neighbor])

        return original_to_dup[node]
